package com.nikasov.data.usecase

import com.nikasov.common.extensions.currentDateTimeInMillis
import com.nikasov.data.local.dao.SessionDao
import com.nikasov.data.local.entity.SessionEntity
import nikasov.domain.entitiy.Advice
import javax.inject.Inject

class CreateSessionUseCase @Inject constructor(
    private val sessionDao: SessionDao
) {

    suspend operator fun invoke(title: String) =
        sessionDao.insertSession(SessionEntity(date = currentDateTimeInMillis, title = title))

}