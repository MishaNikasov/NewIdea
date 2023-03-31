package com.nikasov.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nikasov.data.local.dao.AdviceDao
import com.nikasov.data.local.dao.SessionAndAdviceDao
import com.nikasov.data.local.dao.SessionDao
import com.nikasov.data.local.entity.AdviceEntity
import com.nikasov.data.local.entity.SessionEntity

@Database(
    entities = [AdviceEntity::class, SessionEntity::class],
    version = 1
)
abstract class IdeaDatabase: RoomDatabase() {
    abstract val adviceDao: AdviceDao
    abstract val sessionDao: SessionDao
    abstract val sessionAndAdviceDao: SessionAndAdviceDao
}