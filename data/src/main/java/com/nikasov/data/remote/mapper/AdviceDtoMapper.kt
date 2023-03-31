package com.nikasov.data.remote.mapper

import com.nikasov.data.remote.entity.chatResponse.ChatResponseDto
import nikasov.domain.entitiy.Advice
import timber.log.Timber
import javax.inject.Inject

class AdviceDtoMapper @Inject constructor() {

    fun mapChatResponse(dto: ChatResponseDto?): List<Advice> {
        dto ?: return emptyList()
        dto.choices ?: return emptyList()
        val regex = Regex("\\s*\\d+\\.\\s+")
        val rawContent = dto.choices[0].message?.content.orEmpty()
        val content = rawContent.replace("\n", " ")
        val splitMessages = regex.split(content).drop(1)
        Timber.d("splitMessages: ${splitMessages.joinToString()}")
        return splitMessages.mapIndexed { index, message ->
            Advice(
                id = index.toString(),
                text = message
            )
        }
    }

//    fun map(message: ChatMessageDto): Advice {
//        return Advice(message.content)
//    }

}