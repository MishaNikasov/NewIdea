package com.nikasov.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class FavoriteAndAdvice(
    @Embedded
    val favoriteEntity: FavoriteEntity,
    @Relation(
        parentColumn = "adviceId",
        entityColumn = "adviceId"
    )
    val advice: AdviceEntity
)