package com.nikasov.data.di

import com.nikasov.data.local.dao.AdviceDao
import com.nikasov.data.local.dao.SessionAndAdviceDao
import com.nikasov.data.local.dao.SessionDao
import com.nikasov.data.local.mapper.AdviceMapper
import com.nikasov.data.local.mapper.SessionMapper
import com.nikasov.data.remote.api.ChatApi
import com.nikasov.data.remote.mapper.AdviceDtoMapper
import com.nikasov.data.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideAddAdvicesToSessionUseCase(adviceDao: AdviceDao, adviceMapper: AdviceMapper) =
        AddAdvicesToSessionUseCase(adviceDao, adviceMapper)

    @Provides
    fun provideCreateSessionUseCase(sessionDao: SessionDao) =
        CreateSessionUseCase(sessionDao)

    @Provides
    fun provideGetAdviceListUseCase(chatApi: ChatApi, adviceDtoMapper: AdviceDtoMapper) =
        GetAdviceListUseCase(chatApi, adviceDtoMapper)

    @Provides
    fun provideGetAllSessionUseCase(sessionAndAdviceDao: SessionAndAdviceDao, sessionMapper: SessionMapper) =
        GetAllSessionUseCase(sessionAndAdviceDao, sessionMapper)

    @Provides
    fun provideGetSessionUseCase(sessionAndAdviceDao: SessionAndAdviceDao, sessionMapper: SessionMapper) =
        GetSessionUseCase(sessionAndAdviceDao, sessionMapper)

}