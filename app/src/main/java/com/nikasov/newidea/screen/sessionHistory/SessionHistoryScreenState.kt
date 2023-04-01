package com.nikasov.newidea.screen.sessionHistory

import nikasov.domain.entitiy.Session

data class SessionHistoryScreenState(
    val sessionList: List<Session>
)