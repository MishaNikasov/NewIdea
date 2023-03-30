package com.nikasov.data.api

import com.nikasov.data.entity.chatRequest.ChatRequestBodyDto
import com.nikasov.data.entity.chatResponse.ChatResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatApi {

    @POST("chat/completions")
    suspend fun find(@Body body: ChatRequestBodyDto): Response<ChatResponseDto?>

}