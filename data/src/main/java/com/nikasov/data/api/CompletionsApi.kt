package com.nikasov.data.api

import retrofit2.Response
import retrofit2.http.GET

interface CompletionsApi {

    @GET("")
    fun find(

    ): Response<Unit>

}