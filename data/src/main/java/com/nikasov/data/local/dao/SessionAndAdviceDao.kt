package com.nikasov.data.local.dao

import androidx.room.*
import com.nikasov.data.local.entity.AdviceEntity
import com.nikasov.data.local.entity.SessionAndAdvice
import com.nikasov.data.local.entity.SessionEntity

@Dao
interface SessionAndAdviceDao {
    @Transaction
    @Query("SELECT * FROM sessions WHERE sessionId =:sessionId")
    fun getSessionAndAdvice(sessionId: Int): List<SessionAndAdvice>
}