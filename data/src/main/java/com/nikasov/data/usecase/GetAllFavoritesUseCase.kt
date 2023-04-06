package com.nikasov.data.usecase

import com.nikasov.data.local.dao.FavoriteAndAdviceDao
import com.nikasov.data.local.mapper.AdviceMapper
import javax.inject.Inject

class GetAllFavoritesUseCase @Inject constructor(
    private val favoriteAndAdviceDao: FavoriteAndAdviceDao,
    private val adviceMapper: AdviceMapper
) {

    suspend operator fun invoke() = favoriteAndAdviceDao.getAllFavorites().map {
        adviceMapper.mapFromEntity(it.advice, true)
    }

}