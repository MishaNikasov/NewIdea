package com.nikasov.data.local.mapper

import com.nikasov.data.local.entity.AdviceEntity
import nikasov.domain.entitiy.Advice
import javax.inject.Inject

class AdviceMapper @Inject constructor() {

    fun mapToEntity(advice: Advice, sessionId: Long): AdviceEntity {
        return AdviceEntity(
            text = advice.text,
            sessionId = sessionId
        )
    }

    fun mapFromEntity(adviceEntity: AdviceEntity): Advice {
        return Advice(
            id = adviceEntity.adviceId,
            text = adviceEntity.text
        )
    }

}