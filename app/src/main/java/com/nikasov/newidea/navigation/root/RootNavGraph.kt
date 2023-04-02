package com.nikasov.newidea.navigation.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nikasov.newidea.navigation.Graph
import com.nikasov.newidea.navigation.advice.AdviceDestination
import com.nikasov.newidea.navigation.advice.AdviceRouter
import com.nikasov.newidea.navigation.advice.adviceGraph
import com.nikasov.newidea.navigation.history.HistoryDestination
import com.nikasov.newidea.navigation.history.HistoryRouter
import com.nikasov.newidea.navigation.history.historyGraph
import com.nikasov.newidea.screen.favorite.FavoriteScreen
import com.nikasov.newidea.screen.home.HomeScreen
import com.nikasov.newidea.screen.sessionHistory.SessionHistoryScreen

@Composable
fun RootNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    NavHost(
        navController = navController,
        route = Graph.Root.route,
        startDestination = RootDestination.Home.route,
        modifier = modifier
    ) {
        composable(RootDestination.Home.route) {
            HomeScreen { event ->
                when (event) {
                    is AdviceRouter.Advice -> navController.navigate("${AdviceDestination.Advice.route}/${event.text}")
                    else -> {}
                }
            }
        }
        composable(RootDestination.SessionHistory.route) {
            SessionHistoryScreen({ event ->
                when (event) {
                    is HistoryRouter.AdviceHistory -> {
                        navController.navigate("${HistoryDestination.AdviceHistory.route}/${event.sessionId}")
                    }
                }
            })
        }
        composable(RootDestination.Favorite.route) { FavoriteScreen() }
        historyGraph(navController)
        adviceGraph(navController)
    }

}
