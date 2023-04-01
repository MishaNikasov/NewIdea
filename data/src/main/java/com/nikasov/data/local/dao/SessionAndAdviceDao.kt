package com.nikasov.data.local.dao

import androidx.room.*
import com.nikasov.data.local.entity.SessionAndAdvice

@Dao
interface SessionAndAdviceDao {
    @Transaction
    @Query("SELECT * FROM sessions WHERE sessionId =:sessionId")
    suspend fun getSessionAndAdvice(sessionId: Long): SessionAndAdvice

    @Transaction
    @Query("SELECT * FROM sessions")
    suspend fun getAllSessions(): List<SessionAndAdvice>
}