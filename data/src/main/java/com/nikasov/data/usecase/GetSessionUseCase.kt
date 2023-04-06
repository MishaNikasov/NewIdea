package com.nikasov.data.usecase

import com.nikasov.data.local.dao.FavoriteAndAdviceDao
import com.nikasov.data.local.dao.SessionAndAdviceDao
import com.nikasov.data.local.mapper.SessionMapper
import nikasov.domain.entitiy.Session
import javax.inject.Inject

class GetSessionUseCase @Inject constructor(
    private val sessionAndAdviceDao: SessionAndAdviceDao,
    private val favoriteAndAdviceDao: FavoriteAndAdviceDao,
    private val sessionMapper: SessionMapper,
) {

    suspend operator fun invoke(sessionId: Long): Session {
        val favoritesIdList = favoriteAndAdviceDao.getAllFavorites().map { it.advice.adviceId }
        return sessionMapper.map(sessionAndAdviceDao.getSessionAndAdvice(sessionId), favoritesIdList)
    }

}