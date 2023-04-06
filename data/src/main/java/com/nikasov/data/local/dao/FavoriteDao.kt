package com.nikasov.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.nikasov.data.local.entity.FavoriteEntity

@Dao
interface FavoriteDao {

    @Insert
    suspend fun saveToFavorite(favoriteEntity: FavoriteEntity)

    @Delete
    suspend fun removeFromFavorite(favoriteEntity: FavoriteEntity)

}