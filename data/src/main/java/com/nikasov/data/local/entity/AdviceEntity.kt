package com.nikasov.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "advices")
data class AdviceEntity(
    @PrimaryKey(autoGenerate = true)
    val adviceId: Int = 0,
    val sessionId: Int,
    val text: String
)