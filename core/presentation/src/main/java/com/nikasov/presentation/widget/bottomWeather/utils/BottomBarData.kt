package com.nikasov.presentation.widget.bottomWeather.utils

import com.nikasov.presentation.R

sealed class BottomBarData(
    open val title: String
) {

    object LiveMap : BottomBarData("Live\nmap")
    object Alerts : BottomBarData("Alerts")
    object Favorites : BottomBarData("Favorites ")
    object Menu : BottomBarData("Menu")

    val selectedIcon: Int
        get() = when (this) {
            Alerts -> R.drawable.ic_alerts_selected
            Favorites -> R.drawable.ic_favorites_selected
            LiveMap -> R.drawable.ic_map_selected
            Menu -> R.drawable.ic_menu_selected
        }

    val unselectedIcon: Int
        get() = when (this) {
            Alerts -> R.drawable.ic_alerts_unselected
            Favorites -> R.drawable.ic_favorites_unselected
            LiveMap -> R.drawable.ic_map_unselected
            Menu -> R.drawable.ic_menu_unselected
        }
}