package nikasov.domain.usecase

import com.nikasov.common.utils.DataState
import com.nikasov.common.utils.State
import nikasov.domain.entitiy.Advice
import nikasov.domain.repository.ChatRepository
import javax.inject.Inject

class HandleNewAdviceUseCase @Inject constructor(
    private val chatRepository: ChatRepository
) {

    suspend operator fun invoke(text: String, sessionId: Long): DataState<List<Advice>> {
        return when(val result = chatRepository.getAdvices(text)) {
            is DataState.Error -> DataState.error(result.errorModel)
            is DataState.Success -> {
                val list = result.data ?: emptyList()
                val session = chatRepository.addAdvicesToSession(
                    sessionId = sessionId,
                    list = list
                )
                return DataState.successes(session.advices)
            }
        }
    }

}