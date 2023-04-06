package com.nikasov.data.usecase

import com.nikasov.data.local.dao.FavoriteDao
import com.nikasov.data.local.entity.FavoriteEntity
import nikasov.domain.entitiy.Advice
import javax.inject.Inject

class AddAdviceToFavoriteUseCase @Inject constructor(
    private val favoriteDao: FavoriteDao
) {

    suspend operator fun invoke(advice: Advice) {
        favoriteDao.saveToFavorite(FavoriteEntity(adviceId = advice.id))
    }

}