package nikasov.domain.repository

import nikasov.domain.entitiy.Advice

interface FavoriteRepository {
    suspend fun getAllFavorites(): List<Advice>
    suspend fun saveToFavorite(advice: Advice)
    suspend fun removeFromFavorite(advice: Advice)
}