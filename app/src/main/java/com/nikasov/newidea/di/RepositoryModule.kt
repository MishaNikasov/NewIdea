package com.nikasov.newidea.di

import com.nikasov.data.repository.ChatRepositoryImpl
import com.nikasov.data.usecase.*
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
    fun provideChatRepository(
        getAdviceListUseCase: GetAdviceListUseCase,
        createSessionUseCase: CreateSessionUseCase,
        addAdvicesToSessionUseCase: AddAdvicesToSessionUseCase,
        getAllSessionUseCase: GetAllSessionUseCase,
        getSessionUseCase: GetSessionUseCase
    ): ChatRepository = ChatRepositoryImpl(
        getAdviceListUseCase,
        createSessionUseCase,
        addAdvicesToSessionUseCase,
        getAllSessionUseCase,
        getSessionUseCase
    )

}