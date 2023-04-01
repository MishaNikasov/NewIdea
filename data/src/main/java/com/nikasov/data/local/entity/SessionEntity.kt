package com.nikasov.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sessions")
data class SessionEntity(
    @PrimaryKey(autoGenerate = true)
    val sessionId: Long = 0,
    val title: String,
    val date: Long
)