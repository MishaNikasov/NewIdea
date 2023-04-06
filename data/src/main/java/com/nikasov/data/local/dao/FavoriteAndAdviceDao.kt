package com.nikasov.data.local.dao

import androidx.room.*
import com.nikasov.data.local.entity.FavoriteAndAdvice

@Dao
interface FavoriteAndAdviceDao {
    @Transaction
    @Query("SELECT * FROM favorites WHERE adviceId =:adviceId")
    suspend fun getFavoriteAndAdvice(adviceId: Long): FavoriteAndAdvice

    @Transaction
    @Query("SELECT * FROM favorites")
    suspend fun getAllFavorites(): List<FavoriteAndAdvice>
}