package com.nikasov.newidea.navigation.history

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.nikasov.newidea.navigation.Graph
import com.nikasov.newidea.screen.adviceHostory.AdviceHistoryScreen

fun NavGraphBuilder.historyGraph(navController: NavHostController) {
    navigation(
        route = Graph.History.route,
        startDestination = HistoryDestination.AdviceHistory.route
    ) {
        composable(
            route = "${HistoryDestination.AdviceHistory.route}/{sessionId}",
            arguments = listOf(navArgument("sessionId") { type = NavType.LongType })
        ) { backStackEntry ->
            val sessionId = backStackEntry.arguments?.getLong("sessionId") ?: return@composable
            AdviceHistoryScreen(sessionId)
        }
    }
}