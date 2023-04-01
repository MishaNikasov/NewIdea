package nikasov.domain.repository

import com.nikasov.common.utils.DataState
import nikasov.domain.entitiy.Advice
import nikasov.domain.entitiy.Session

interface ChatRepository {
    suspend fun getAdvices(text: String): DataState<List<Advice>>
    suspend fun createSession(title: String): Long
    suspend fun addAdvicesToSession(sessionId: Long, list: List<Advice>)
    suspend fun getAllSessions(): List<Session>
    suspend fun getSession(sessionId: Long): Session
}