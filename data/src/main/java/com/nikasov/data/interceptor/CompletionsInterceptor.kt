package com.nikasov.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class CompletionsInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("model", "text-davinci-003")
            .addQueryParameter("max_tokens", "7")
            .addQueryParameter("temperature", "0")
            .build()

        val request = original.newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}