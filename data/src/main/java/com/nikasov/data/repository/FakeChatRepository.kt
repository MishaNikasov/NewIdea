//package com.nikasov.data.repository
//
//import com.nikasov.common.utils.DataState
//import nikasov.domain.entitiy.Advice
//import nikasov.domain.entitiy.Session
//import nikasov.domain.repository.ChatRepository
//
//class FakeChatRepository : ChatRepository {
//
//    override suspend fun getAdvices(text: String): DataState<List<Advice>> {
//        return DataState.successes(
//            listOf(
//                Advice(1L, "yx11v421yre"),
//                Advice(2L, "y41421t1423yre"),
//                Advice(3L, "x4y42c11yre"),
//            )
//        )
//    }
//
//    override suspend fun createSession(title: String) = 0L
//
//    override suspend fun addAdvicesToSession(sessionId: Long, list: List<Advice>) { }
//
//    override suspend fun getAllSessions(): List<Session> = emptyList()
//
//    override suspend fun getSession(sessionId: Long): Session {
//
//    }
//
//}