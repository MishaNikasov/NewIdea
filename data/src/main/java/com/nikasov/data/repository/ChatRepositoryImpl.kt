package com.nikasov.data.repository

import com.nikasov.common.base.BaseRepository
import com.nikasov.common.utils.DataState
import com.nikasov.data.api.ChatApi
import com.nikasov.data.entity.ChatMessageDto
import com.nikasov.data.entity.Role
import com.nikasov.data.entity.chatRequest.ChatRequestBodyDto
import com.nikasov.data.mapper.AdviceMapper
import nikasov.domain.entitiy.Advice
import nikasov.domain.repository.ChatRepository
import javax.inject.Inject

private const val GPT_MODEL = "gpt-3.5-turbo"

class ChatRepositoryImpl @Inject constructor(
    private val chatApi: ChatApi,
    private val mapper: AdviceMapper
) : BaseRepository(), ChatRepository {

    override suspend fun getAdvices(text: String): DataState<List<Advice>> {
        val messages = listOf(
            ChatMessageDto(
                Role.System.value,
                "You are a generator of useful ideas."
            ),
            ChatMessageDto(
                Role.User.value,
                "give me 3 very short ideas to improve myself in the topic: $text"
            )
        )
        val body = ChatRequestBodyDto(
            model = GPT_MODEL,
            temperature = 0.2f,
            messages = messages
        )
        return DataState.successes(
            listOf(
                Advice("12345", "yx11v421yre"),
                Advice("12345", "y41421t1423yre"),
                Advice("12345", "x4y42c11yre"),
            )
        )
        return obtain(
            request = chatApi.find(body),
            mapper = { mapper.mapChatResponse(it) }
        )
    }

}