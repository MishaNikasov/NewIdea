package com.nikasov.data.di

import com.nikasov.data.local.dao.AdviceDao
import com.nikasov.data.local.dao.FavoriteAndAdviceDao
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

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    fun provideAddAdvicesToSessionUseCase(adviceDao: AdviceDao, favoriteAndAdviceDao: FavoriteAndAdviceDao, sessionAndAdviceDao: SessionAndAdviceDao, sessionMapper: SessionMapper, adviceMapper: AdviceMapper) =
        AddAdvicesToSessionUseCase(adviceDao, sessionAndAdviceDao, favoriteAndAdviceDao, sessionMapper, adviceMapper)

    @Provides
    fun provideCreateSessionUseCase(sessionDao: SessionDao) =
        CreateSessionUseCase(sessionDao)

    @Provides
    fun provideGetAdviceListUseCase(chatApi: ChatApi, adviceDtoMapper: AdviceDtoMapper) =
        GetAdviceListUseCase(chatApi, adviceDtoMapper)

    @Provides
    fun provideGetAllSessionUseCase(sessionAndAdviceDao: SessionAndAdviceDao, favoriteAndAdviceDao: FavoriteAndAdviceDao, sessionMapper: SessionMapper) =
        GetAllSessionUseCase(sessionAndAdviceDao, favoriteAndAdviceDao, sessionMapper)

    @Provides
    fun provideGetSessionUseCase(sessionAndAdviceDao: SessionAndAdviceDao, favoriteAndAdviceDao: FavoriteAndAdviceDao, sessionMapper: SessionMapper) =
        GetSessionUseCase(sessionAndAdviceDao, favoriteAndAdviceDao, sessionMapper)

    @Provides
    fun provideGetAllFavoritesUseCase(favoriteAndAdviceDao: FavoriteAndAdviceDao, adviceMapper: AdviceMapper) =
        GetAllFavoritesUseCase(favoriteAndAdviceDao, adviceMapper)

}