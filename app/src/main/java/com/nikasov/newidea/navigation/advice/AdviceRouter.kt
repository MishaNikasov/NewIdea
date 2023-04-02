package com.nikasov.newidea.navigation.advice

sealed class AdviceRouter {
    data class Advice(val text: String): AdviceRouter()
}