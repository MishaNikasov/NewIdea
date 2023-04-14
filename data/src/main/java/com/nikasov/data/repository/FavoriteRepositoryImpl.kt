package com.nikasov.data.repository

import com.nikasov.common.base.BaseRepository
import com.nikasov.data.local.dao.FavoriteAndAdviceDao
import com.nikasov.data.local.dao.FavoriteDao
import com.nikasov.data.local.entity.FavoriteEntity
import com.nikasov.data.local.mapper.AdviceMapper
import nikasov.domain.entitiy.Advice
import nikasov.domain.repository.FavoriteRepository
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor(
    private val favoriteDao: FavoriteDao,
    private val favoriteAndAdviceDao: FavoriteAndAdviceDao,
    private val adviceMapper: AdviceMapper
) : BaseRepository(), FavoriteRepository {

    override suspend fun getAllFavorites() = favoriteAndAdviceDao.getAllFavorites().map {
        adviceMapper.mapFromEntity(it.advice, true)
    }


    override suspend fun saveToFavorite(advice: Advice) {
        favoriteDao.saveToFavorite(FavoriteEntity(adviceId = advice.id))
    }

    override suspend fun removeFromFavorite(advice: Advice) {

    }

}