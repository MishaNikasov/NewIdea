package nikasov.domain.usecase

import com.nikasov.common.utils.DataState
import com.nikasov.common.utils.State
import nikasov.domain.entitiy.Advice
import nikasov.domain.repository.ChatRepository

class HandleNewAdviceUseCase(
    private val chatRepository: ChatRepository
) {

    suspend operator fun invoke(text: String, sessionId: Long): State<List<Advice>> {
        when(val result = chatRepository.getAdvices(searchText)) {
            is DataState.Error -> _screenState.emit(State.error())
            is DataState.Success -> {
                val list = result.data ?: emptyList()
                val session = chatRepository.addAdvicesToSession(
                    sessionId = currentSessionId ?: return,
                    list = list
                )
                return session.advices
            }
        }
    }

}