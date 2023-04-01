package com.nikasov.newidea.screen.advice

import nikasov.domain.entitiy.Advice

data class AdviceScreenState(
    val title: String,
    val adviceList: List<Advice>
)