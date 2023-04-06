package com.nikasov.data.repository

import com.nikasov.common.base.BaseRepository
import com.nikasov.data.usecase.AddAdviceToFavoriteUseCase
import com.nikasov.data.usecase.GetAllFavoritesUseCase
import nikasov.domain.entitiy.Advice
import nikasov.domain.repository.FavoriteRepository
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val addAdviceToFavoriteUseCase: AddAdviceToFavoriteUseCase,
    private val getAllFavoritesUseCase: GetAllFavoritesUseCase
): BaseRepository(), FavoriteRepository {

    override suspend fun getAllFavorites() = getAllFavoritesUseCase()

    override suspend fun saveToFavorite(advice: Advice) = addAdviceToFavoriteUseCase(advice)

    override suspend fun removeFromFavorite(advice: Advice) {

    }

}