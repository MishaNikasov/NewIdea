package com.nikasov.newidea.screen.root

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.nikasov.newidea.navigation.root.RootDestination
import com.nikasov.newidea.navigation.root.RootNavGraph
import com.nikasov.presentation.widget.bottomBar.BottomBar
import com.nikasov.presentation.widget.bottomBar.BottomBarItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootScreen(navController: NavHostController) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController, rootBottomBarItems) }
    ) {
        RootNavGraph(
            navController = navController,
            modifier = Modifier.padding(bottom = it.calculateBottomPadding())
        )
    }
}

private val rootBottomBarItems = listOf(
    BottomBarItem(
        route = RootDestination.Home.route,
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
    ),
    BottomBarItem(
        route = RootDestination.SessionHistory.route,
        title = "History",
        selectedIcon = Icons.Filled.List,
        unselectedIcon = Icons.Outlined.List,
    ),
    BottomBarItem(
        route = RootDestination.Favorite.route,
        title = "Favorite",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Filled.FavoriteBorder,
    )
)