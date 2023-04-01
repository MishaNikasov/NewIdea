package com.nikasov.data.usecase

import com.nikasov.common.base.BaseUseCase
import com.nikasov.common.utils.DataState
import com.nikasov.data.remote.api.ChatApi
import com.nikasov.data.remote.entity.ChatMessageDto
import com.nikasov.data.remote.entity.Role
import com.nikasov.data.remote.entity.chatRequest.ChatRequestBodyDto
import com.nikasov.data.remote.mapper.AdviceDtoMapper
import nikasov.domain.entitiy.Advice
import javax.inject.Inject

private const val GPT_MODEL = "gpt-3.5-turbo"
private const val GPT_SYSTEM_CONTENT = "You are a generator of useful ideas."
private const val GPT_USER_CONTENT = "Give me 3 very short ideas to improve myself in the topic:"

class GetAdviceListUseCase @Inject constructor(
    private val chatApi: ChatApi,
    private val adviceDtoMapper: AdviceDtoMapper
): BaseUseCase() {

    suspend operator fun invoke(text: String): DataState<List<Advice>> {
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
}