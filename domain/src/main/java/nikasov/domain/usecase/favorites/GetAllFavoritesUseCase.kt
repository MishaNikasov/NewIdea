package nikasov.domain.usecase.favorites

import nikasov.domain.repository.FavoriteRepository
import javax.inject.Inject

class GetAllFavoritesUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {
    suspend operator fun invoke() = favoriteRepository.getAllFavorites()
}