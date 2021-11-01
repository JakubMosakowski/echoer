package com.jakmos.echoer.presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.jakmos.echoer.presentation.main.MainDestinations.AUTH_ROUTE
import com.jakmos.echoer.presentation.main.MainDestinations.HOME_ROUTE
import com.jakmos.echoer.presentation.main.auth.AuthDestinations.SIGN_UP_ROUTE
import com.jakmos.echoer.presentation.main.auth.authentication
import com.jakmos.echoer.presentation.main.home.HomeDestinations.DASHBOARD_ROUTE
import com.jakmos.echoer.presentation.main.home.home


enum class MainDestinations {
    HOME_ROUTE,
    AUTH_ROUTE
}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) = NavHost(
    navController = navController,
    startDestination = AUTH_ROUTE.toString()
) {
    navigation(
        route = AUTH_ROUTE.toString(),
        startDestination = SIGN_UP_ROUTE.toString()
    ) { authentication() }

    navigation(
        route = HOME_ROUTE.toString(),
        startDestination = DASHBOARD_ROUTE.toString()
    ) { home() }
}
