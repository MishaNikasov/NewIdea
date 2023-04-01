package com.nikasov.data.usecase

import com.nikasov.data.local.dao.SessionAndAdviceDao
import com.nikasov.data.local.mapper.SessionMapper
import javax.inject.Inject

class GetSessionUseCase @Inject constructor(
    private val sessionAndAdviceDao: SessionAndAdviceDao,
    private val sessionMapper: SessionMapper,
) {

    suspend operator fun invoke(sessionId: Long) =
        sessionMapper.map(sessionAndAdviceDao.getSessionAndAdvice(sessionId))

}