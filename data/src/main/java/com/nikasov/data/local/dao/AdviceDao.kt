package com.nikasov.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.nikasov.data.local.entity.AdviceEntity

@Dao
interface AdviceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAdvice(adviceEntity: AdviceEntity)

    @Delete
    suspend fun deleteAdvice(adviceEntity: AdviceEntity)
}