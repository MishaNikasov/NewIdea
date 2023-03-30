package com.nikasov.data.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.gson.Gson
import com.nikasov.data.api.ChatApi
import com.nikasov.data.interceptor.ApiInterceptor
import com.nikasov.data.interceptor.ChatInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ChatModule {

    @Provides
    @Singleton
    @Named("completions")
    fun provideCompletionsOkHttpClient(
        chuckerInterceptor: ChuckerInterceptor,
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(GENERAL_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(GENERAL_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(GENERAL_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(ApiInterceptor())
            .addInterceptor(ChatInterceptor())
            .addInterceptor(chuckerInterceptor)

        return builder.build()
    }

    @Provides
    @Singleton
    @Named("completions")
    fun provideCompletionsRetrofit(@Named("completions") okHttpClient: OkHttpClient, gsonBuilder: Gson): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.openai.com/v1/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
            .build()
    }

    @Provides
    @Singleton
    fun provideChatApi(@Named("completions") retrofit: Retrofit): ChatApi {
        return retrofit.create(ChatApi::class.java)
    }

}