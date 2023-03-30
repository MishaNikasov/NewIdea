package com.nikasov.newidea.navigation.main

sealed class MainRouter {
    object Home: MainRouter()
    data class Advice(val text: String): MainRouter()
}