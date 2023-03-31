package com.nikasov.data.remote.entity.chatResponse

import com.google.gson.annotations.SerializedName

data class ChatResponseDto(
    @SerializedName("choices")
    val choices: List<ChoiceDto>?,
    @SerializedName("created")
    val created: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("model")
    val model: String?,
    @SerializedName("object")
    val `object`: String?,
    @SerializedName("usage")
    val usage: UsageDto?
)