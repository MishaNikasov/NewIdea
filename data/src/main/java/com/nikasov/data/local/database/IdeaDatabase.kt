package com.nikasov.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nikasov.data.local.dao.*
import com.nikasov.data.local.entity.AdviceEntity
import com.nikasov.data.local.entity.FavoriteEntity
import com.nikasov.data.local.entity.SessionEntity

@Database(
    entities = [AdviceEntity::class, SessionEntity::class, FavoriteEntity::class],
    version = 4
)
abstract class IdeaDatabase: RoomDatabase() {
    abstract val adviceDao: AdviceDao
    abstract val sessionDao: SessionDao
    abstract val sessionAndAdviceDao: SessionAndAdviceDao
    abstract val favoriteDao: FavoriteDao
    abstract val favoriteAndAdviceDao: FavoriteAndAdviceDao
}