package com.nikasov.data.local.mapper

import com.nikasov.data.local.entity.AdviceEntity
import nikasov.domain.entitiy.Advice

class AdviceMapper {

    fun map(advice: Advice): AdviceEntity {
        return AdviceEntity(
            text = advice.text,

        )
    }

}