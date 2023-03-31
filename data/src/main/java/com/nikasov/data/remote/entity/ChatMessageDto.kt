package com.nikasov.data.remote.entity

import com.google.gson.annotations.SerializedName

data class ChatMessageDto(
    @SerializedName("role")
    val role: String,
    @SerializedName("content")
    val content: String
)