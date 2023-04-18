package nikasov.domain.usecase.favorites

import nikasov.domain.entitiy.Advice
import nikasov.domain.repository.FavoriteRepository
import javax.inject.Inject

class AddToFavoritesUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {
    suspend operator fun invoke(advice: Advice) = favoriteRepository.saveToFavorite(advice)
}