package com.nikasov.newidea.navigation.advice

import androidx.navigation.*
import androidx.navigation.compose.composable
import com.nikasov.newidea.navigation.Graph
import com.nikasov.newidea.screen.advice.AdviceScreen

fun NavGraphBuilder.adviceGraph(navController: NavHostController) {
    navigation(
        route = Graph.Advice.route,
        startDestination = AdviceDestination.Advice.route
    ) {
        composable(
            route = "${AdviceDestination.Advice.route}/{searchText}",
            arguments = listOf(navArgument("searchText") { type = NavType.StringType })
        ) { backStackEntry ->
            val searchText = backStackEntry.arguments?.getString("searchText").orEmpty()
            AdviceScreen(searchText)
        }
    }
}