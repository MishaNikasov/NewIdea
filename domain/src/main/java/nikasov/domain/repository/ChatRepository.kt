package nikasov.domain.repository

import com.nikasov.common.utils.DataState
import nikasov.domain.entitiy.Advice

interface ChatRepository {
    suspend fun getAdvices(text: String): DataState<List<Advice>>
}