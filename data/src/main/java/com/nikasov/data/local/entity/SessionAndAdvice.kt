package com.nikasov.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class SessionAndAdvice(
    @Embedded val session: SessionEntity,
    @Relation(
        parentColumn = "sessionId",
        entityColumn = "adviceId"
    )
    val adviceList: List<AdviceEntity>
)