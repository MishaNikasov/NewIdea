package com.nikasov.presentation.widget.bottomBar

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(navController: NavHostController, items: List<BottomBarItem>) {

    var selectedItem by remember { mutableStateOf(0) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = items.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        NavigationBar {
            items.forEachIndexed { index, item ->
                NavigationBarItem(
                    label = { Text(text = item.title) },
                    icon = {
                        val icon = if (selectedItem == index) item.selectedIcon else item.unselectedIcon
                        Icon(imageVector = icon, contentDescription = item.title)
                    },
                    selected = selectedItem == index,
                    onClick = {
                        selectedItem = index
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.findStartDestination().id)
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}