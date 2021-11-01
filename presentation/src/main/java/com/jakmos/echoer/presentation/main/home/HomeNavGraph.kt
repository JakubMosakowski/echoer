package com.jakmos.echoer.presentation.main.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


enum class HomeDestinations {
    DASHBOARD_ROUTE
}

fun NavGraphBuilder.home() {
    composable(HomeDestinations.DASHBOARD_ROUTE.toString()) {
        Home()
    }
}
