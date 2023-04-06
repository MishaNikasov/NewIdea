package com.nikasov.data.usecase

import com.nikasov.data.local.dao.AdviceDao
import com.nikasov.data.local.dao.FavoriteAndAdviceDao
import com.nikasov.data.local.dao.SessionAndAdviceDao
import com.nikasov.data.local.mapper.AdviceMapper
import com.nikasov.data.local.mapper.SessionMapper
import nikasov.domain.entitiy.Advice
import nikasov.domain.entitiy.Session
import javax.inject.Inject

class AddAdvicesToSessionUseCase @Inject constructor(
    private val adviceDao: AdviceDao,
    private val sessionAndAdviceDao: SessionAndAdviceDao,
    private val favoriteAndAdviceDao: FavoriteAndAdviceDao,
    private val sessionMapper: SessionMapper,
    private val adviceMapper: AdviceMapper
) {

    suspend operator fun invoke(sessionId: Long, list: List<Advice>): Session {
        list.forEach { adviceDao.insertAdvice(adviceMapper.mapToEntity(it, sessionId)) }
        val favoritesIdList = favoriteAndAdviceDao.getAllFavorites().map { it.advice.adviceId }
        return sessionMapper.map(sessionAndAdviceDao.getSessionAndAdvice(sessionId), favoritesIdList)
    }

}