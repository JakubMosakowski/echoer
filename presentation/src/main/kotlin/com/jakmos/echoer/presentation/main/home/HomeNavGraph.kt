package com.jakmos.echoer.presentation.main.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.jakmos.echoer.presentation.main.MainDestinations.HOME_ROUTE
import com.jakmos.echoer.presentation.main.home.HomeDestinations.DASHBOARD_ROUTE
import com.jakmos.echoer.presentation.main.home.dashboard.Dashboard

fun NavGraphBuilder.addHomeGraph() = navigation(
    route = HOME_ROUTE.toString(),
    startDestination = DASHBOARD_ROUTE.toString()
) {
    addDashboardScreen()
}

private fun NavGraphBuilder.addDashboardScreen() =
    composable(DASHBOARD_ROUTE.toString()) {
        Dashboard()
    }

enum class HomeDestinations {
    DASHBOARD_ROUTE
}
