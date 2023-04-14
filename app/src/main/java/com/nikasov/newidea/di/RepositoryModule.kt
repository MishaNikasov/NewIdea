package com.nikasov.newidea.di

import com.nikasov.data.local.dao.*
import com.nikasov.data.local.mapper.AdviceMapper
import com.nikasov.data.local.mapper.SessionMapper
import com.nikasov.data.remote.api.ChatApi
import com.nikasov.data.remote.mapper.AdviceDtoMapper
import com.nikasov.data.repository.ChatRepositoryImpl
import com.nikasov.data.repository.FavoriteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import nikasov.domain.repository.ChatRepository
import nikasov.domain.repository.FavoriteRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideChatRepository(
        chatApi: ChatApi,
        adviceDtoMapper: AdviceDtoMapper,
        sessionDao: SessionDao,
        adviceDao: AdviceDao,
        sessionAndAdviceDao: SessionAndAdviceDao,
        favoriteAndAdviceDao: FavoriteAndAdviceDao,
        sessionMapper: SessionMapper,
        adviceMapper: AdviceMapper
    ): ChatRepository = ChatRepositoryImpl(
        chatApi,
        adviceDtoMapper,
        sessionDao,
        adviceDao,
        sessionAndAdviceDao,
        favoriteAndAdviceDao,
        sessionMapper,
        adviceMapper
    )

    @Singleton
    @Provides
    fun provideFavoriteRepository(
        favoriteDao: FavoriteDao,
        favoriteAndAdviceDao: FavoriteAndAdviceDao,
        adviceMapper: AdviceMapper
    ): FavoriteRepository = FavoriteRepositoryImpl(
        favoriteDao,
        favoriteAndAdviceDao,
        adviceMapper
    )

}