package com.nikasov.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.nikasov.data.local.entity.SessionEntity

@Dao
interface SessionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSession(sessionEntity: SessionEntity)

    @Delete
    suspend fun deleteSession(sessionEntity: SessionEntity)
}