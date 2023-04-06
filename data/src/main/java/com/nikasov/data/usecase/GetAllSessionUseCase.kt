package com.nikasov.data.usecase

import com.nikasov.data.local.dao.FavoriteAndAdviceDao
import com.nikasov.data.local.dao.SessionAndAdviceDao
import com.nikasov.data.local.mapper.SessionMapper
import nikasov.domain.entitiy.Session
import javax.inject.Inject

class GetAllSessionUseCase @Inject constructor(
    private val sessionAndAdviceDao: SessionAndAdviceDao,
    private val favoriteAndAdviceDao: FavoriteAndAdviceDao,
    private val sessionMapper: SessionMapper,
) {

    suspend operator fun invoke(): List<Session> {
        val sessions = sessionAndAdviceDao.getAllSessions()
        val favoritesIdList = favoriteAndAdviceDao.getAllFavorites().map { it.advice.adviceId }
        return sessions.map { sessionMapper.map(it, favoritesIdList) }
    }

}