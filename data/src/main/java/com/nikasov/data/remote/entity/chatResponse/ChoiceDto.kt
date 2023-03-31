package com.nikasov.data.remote.entity.chatResponse

import com.google.gson.annotations.SerializedName
import com.nikasov.data.remote.entity.ChatMessageDto

data class ChoiceDto(
    @SerializedName("finish_reason")
    val finish_reason: String?,
    @SerializedName("index")
    val index: Int?,
    @SerializedName("message")
    val message: ChatMessageDto?
)