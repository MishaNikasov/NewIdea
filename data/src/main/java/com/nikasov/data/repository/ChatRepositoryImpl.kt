package com.nikasov.data.repository

import com.nikasov.common.base.BaseRepository
import com.nikasov.data.usecase.*
import nikasov.domain.entitiy.Advice
import nikasov.domain.entitiy.Session
import nikasov.domain.repository.ChatRepository
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(
    private val getAdviceListUseCase: GetAdviceListUseCase,
    private val createSessionUseCase: CreateSessionUseCase,
    private val addAdvicesToSessionUseCase: AddAdvicesToSessionUseCase,
    private val getAllSessionUseCase: GetAllSessionUseCase,
    private val getSessionUseCase: GetSessionUseCase
) : BaseRepository(), ChatRepository {

    override suspend fun getAdvices(text: String) = getAdviceListUseCase(text)

    override suspend fun createSession(title: String) = createSessionUseCase(title)

    override suspend fun addAdvicesToSession(sessionId: Long, list: List<Advice>) = addAdvicesToSessionUseCase(sessionId, list)

    override suspend fun getAllSessions(): List<Session> = getAllSessionUseCase()

    override suspend fun getSession(sessionId: Long) = getSessionUseCase(sessionId)

}