package com.nikasov.newidea.di

import com.nikasov.data.remote.api.ChatApi
import com.nikasov.data.remote.mapper.AdviceDtoMapper
import com.nikasov.data.repository.ChatRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nikasov.domain.repository.ChatRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideChatRepository(chatApi: ChatApi, mapper: AdviceDtoMapper): ChatRepository = ChatRepositoryImpl(chatApi, mapper)

}