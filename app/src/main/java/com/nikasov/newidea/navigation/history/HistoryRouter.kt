package com.nikasov.newidea.navigation.history

sealed class HistoryRouter {
    data class AdviceHistory(val sessionId: Long): HistoryRouter()
}