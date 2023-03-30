package com.nikasov.data.entity

import com.google.gson.annotations.SerializedName

data class ChatMessageDto(
    @SerializedName("role")
    val role: String,
    @SerializedName("content")
    val content: String
)