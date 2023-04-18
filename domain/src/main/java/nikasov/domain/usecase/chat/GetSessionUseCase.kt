package nikasov.domain.usecase.chat

import nikasov.domain.repository.ChatRepository
import javax.inject.Inject

class GetSessionUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {
    suspend operator fun invoke(sessionId: Long) = chatRepository.getSession(sessionId)
}