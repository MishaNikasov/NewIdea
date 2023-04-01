package com.nikasov.data.usecase

import com.nikasov.data.local.dao.AdviceDao
import com.nikasov.data.local.mapper.AdviceMapper
import nikasov.domain.entitiy.Advice
import javax.inject.Inject

class AddAdvicesToSessionUseCase @Inject constructor(
    private val adviceDao: AdviceDao,
    private val adviceMapper: AdviceMapper
) {

    suspend operator fun invoke(sessionId: Long, list: List<Advice>) {
        list.forEach { adviceDao.insertAdvice(adviceMapper.mapToEntity(it, sessionId)) }
    }

}