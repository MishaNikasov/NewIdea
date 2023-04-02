package com.nikasov.presentation.widget.bottomBar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem(
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)