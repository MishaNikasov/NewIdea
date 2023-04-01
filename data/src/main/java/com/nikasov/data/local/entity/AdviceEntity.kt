package com.nikasov.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "advices")
data class AdviceEntity(
    @PrimaryKey(autoGenerate = true)
    val adviceId: Long = 0,
    val sessionId: Long,
    val text: String
)