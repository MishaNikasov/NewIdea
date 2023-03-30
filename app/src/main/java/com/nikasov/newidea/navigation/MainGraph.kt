package com.nikasov.newidea.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.nikasov.newidea.screen.advice.AdviceScreen
import com.nikasov.newidea.screen.home.HomeScreen

@Composable
fun MainGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.Main.route,
        startDestination = MainDestination.Home.route
    ) {
        composable(MainDestination.Home.route) {
            HomeScreen { searchText ->
                navHostController.navigate("${MainDestination.Advice.route}/$searchText")
            }
        }
        composable(
            route = "${MainDestination.Advice.route}/{searchText}",
            arguments = listOf(navArgument("searchText") { type = NavType.StringType })
        ) { backStackEntry ->
            val searchText = backStackEntry.arguments?.getString("searchText").orEmpty()
            AdviceScreen(searchText)
        }
    }

}

sealed class MainDestination {

    object Home : MainDestination()
    object Advice : MainDestination()

    val route: String
        get() = when (this) {
            Home -> "home"
            Advice -> "advice"
        }

}