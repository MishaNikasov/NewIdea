package com.nikasov.newidea.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.nikasov.newidea.navigation.Graph
import com.nikasov.newidea.screen.advice.AdviceScreen
import com.nikasov.newidea.screen.adviceHostory.AdviceHistoryScreen
import com.nikasov.newidea.screen.home.HomeScreen
import com.nikasov.newidea.screen.sessionHistory.SessionHistoryScreen

@Composable
fun MainGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.Main.route,
        startDestination = MainDestination.SessionHistory.route
    ) {
        composable(MainDestination.Home.route) {
            HomeScreen { event ->
                when (event) {
                    is MainRouter.Advice -> navHostController.navigate("${MainDestination.Advice.route}/${event.text}")
                    else -> { }
                }
            }
        }
        composable(
            route = "${MainDestination.Advice.route}/{searchText}",
            arguments = listOf(navArgument("searchText") { type = NavType.StringType })
        ) { backStackEntry ->
            val searchText = backStackEntry.arguments?.getString("searchText").orEmpty()
            AdviceScreen(searchText)
        }
        composable(
            route = "${MainDestination.AdviceHistory.route}/{sessionId}",
            arguments = listOf(navArgument("sessionId") { type = NavType.LongType })
        ) { backStackEntry ->
            val sessionId = backStackEntry.arguments?.getLong("sessionId") ?: return@composable
            AdviceHistoryScreen(sessionId)
        }
        composable(MainDestination.SessionHistory.route) {
            SessionHistoryScreen({ event ->
                when (event) {
                    is MainRouter.AdviceHistory -> navHostController.navigate("${MainDestination.AdviceHistory.route}/${event.sessionId}")
                    else -> { }
                }
            })
        }
    }

}