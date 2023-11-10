package com.jakmos.echoer.presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.jakmos.echoer.presentation.main.MainDestinations.AUTH_ROUTE
import com.jakmos.echoer.presentation.main.auth.addAuthGraph
import com.jakmos.echoer.presentation.main.home.addHomeGraph

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) = NavHost(
    navController = navController,
    startDestination = AUTH_ROUTE.toString()
) {
    addAuthGraph(navController)
    addHomeGraph()
}

enum class MainDestinations {
    HOME_ROUTE,
    AUTH_ROUTE
}
