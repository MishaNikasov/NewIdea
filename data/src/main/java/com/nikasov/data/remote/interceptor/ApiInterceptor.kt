package com.nikasov.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val request = original.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Authorization", "Bearer ")
            .url(originalHttpUrl)
            .build()

        return chain.proceed(request)
    }
}