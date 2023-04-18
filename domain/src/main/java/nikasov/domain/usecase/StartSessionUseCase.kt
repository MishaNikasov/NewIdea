package nikasov.domain.usecase

import nikasov.domain.repository.ChatRepository
import javax.inject.Inject

class StartSessionUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {

    suspend operator fun invoke(title: String) = chatRepository.createSession(title)

}