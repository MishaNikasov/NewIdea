package com.nikasov.data.remote.entity.chatResponse

import com.google.gson.annotations.SerializedName

data class UsageDto(
    @SerializedName("completion_tokens")
    val completion_tokens: Int?,
    @SerializedName("prompt_tokens")
    val prompt_tokens: Int?,
    @SerializedName("total_tokens")
    val total_tokens: Int?
)