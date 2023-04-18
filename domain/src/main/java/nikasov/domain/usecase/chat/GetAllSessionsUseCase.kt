package nikasov.domain.usecase.chat

import nikasov.domain.repository.ChatRepository
import javax.inject.Inject

class GetAllSessionsUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {
    suspend operator fun invoke() = chatRepository.getAllSessions()
}