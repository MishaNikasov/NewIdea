package com.nikasov.data.remote.entity.chatRequest

import com.google.gson.annotations.SerializedName
import com.nikasov.data.remote.entity.ChatMessageDto

data class ChatRequestBodyDto(
    @SerializedName("model")
    val model: String,
    @SerializedName("temperature")
    val temperature: Float,
    @SerializedName("messages")
    val messages: List<ChatMessageDto>
)