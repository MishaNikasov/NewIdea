package com.nikasov.data.repository

import com.nikasov.common.base.BaseRepository
import com.nikasov.common.extensions.currentDateTimeInMillis
import com.nikasov.common.utils.DataState
import com.nikasov.data.local.dao.AdviceDao
import com.nikasov.data.local.dao.FavoriteAndAdviceDao
import com.nikasov.data.local.dao.SessionAndAdviceDao
import com.nikasov.data.local.dao.SessionDao
import com.nikasov.data.local.entity.SessionEntity
import com.nikasov.data.local.mapper.AdviceMapper
import com.nikasov.data.local.mapper.SessionMapper
import com.nikasov.data.remote.api.ChatApi
import com.nikasov.data.remote.entity.ChatMessageDto
import com.nikasov.data.remote.entity.Role
import com.nikasov.data.remote.entity.chatRequest.ChatRequestBodyDto
import com.nikasov.data.remote.mapper.AdviceDtoMapper
import nikasov.domain.entitiy.Advice
import nikasov.domain.entitiy.Session
import nikasov.domain.repository.ChatRepository
import javax.inject.Inject

private const val GPT_MODEL = "gpt-3.5-turbo"
private const val GPT_SYSTEM_CONTENT = "You are a generator of useful ideas."
private const val GPT_USER_CONTENT = "Give me 3 very short ideas to improve myself in the topic:"

class ChatRepositoryImpl @Inject constructor(
    private val chatApi: ChatApi,
    private val adviceDtoMapper: AdviceDtoMapper,
    private val sessionDao: SessionDao,
    private val adviceDao: AdviceDao,
    private val sessionAndAdviceDao: SessionAndAdviceDao,
    private val favoriteAndAdviceDao: FavoriteAndAdviceDao,
    private val sessionMapper: SessionMapper,
    private val adviceMapper: AdviceMapper
) : BaseRepository(), ChatRepository {

    override suspend fun getAdvices(text: String): DataState<List<Advice>> {
        val messages = listOf(
            ChatMessageDto(
                role = Role.System.value,
                content = GPT_SYSTEM_CONTENT
            ),
            ChatMessageDto(
                role = Role.User.value,
                content = "$GPT_USER_CONTENT $text"
            )
        )
        val body = ChatRequestBodyDto(
            model = GPT_MODEL,
            temperature = 0.2f,
            messages = messages
        )
        return obtain(
            request = chatApi.find(body),
            mapper = { adviceDtoMapper.mapChatResponse(it) }
        )

    }

    override suspend fun createSession(title: String) =
        sessionDao.insertSession(SessionEntity(date = currentDateTimeInMillis, title = title))


    override suspend fun addAdvicesToSession(sessionId: Long, list: List<Advice>) : Session {
        list.forEach { adviceDao.insertAdvice(adviceMapper.mapToEntity(it, sessionId)) }
        val favoritesIdList = favoriteAndAdviceDao.getAllFavorites().map { it.advice.adviceId }
        return sessionMapper.map(sessionAndAdviceDao.getSessionAndAdvice(sessionId), favoritesIdList)
    }

    override suspend fun getAllSessions() : List<Session> {
        val sessions = sessionAndAdviceDao.getAllSessions()
        val favoritesIdList = favoriteAndAdviceDao.getAllFavorites().map { it.advice.adviceId }
        return sessions.map { sessionMapper.map(it, favoritesIdList) }
    }

    override suspend fun getSession(sessionId: Long): Session {
        val favoritesIdList = favoriteAndAdviceDao.getAllFavorites().map { it.advice.adviceId }
        return sessionMapper.map(sessionAndAdviceDao.getSessionAndAdvice(sessionId), favoritesIdList)
    }

}