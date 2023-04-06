package com.nikasov.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    val favoriteId: Long = 0L,
    val adviceId: Long
)