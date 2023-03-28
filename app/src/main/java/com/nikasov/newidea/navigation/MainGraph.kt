package com.nikasov.newidea.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nikasov.newidea.screen.home.HomeScreen

@Composable
fun MainGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.Main.route,
        startDestination = MainDestination.Home.route
    ) {
        composable(MainDestination.Home.route) { HomeScreen() }
    }

}

sealed class MainDestination {

    object Home: MainDestination()

    val route: String
        get() = when(this) {
            Home -> "home"
        }

}