package com.jakmos.echoer.presentation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jakmos.echoer.presentation.main.home.Home


object MainDestinations {
    const val HOME_ROUTE = "home"
}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = MainDestinations.HOME_ROUTE
    ) {
        composable(MainDestinations.HOME_ROUTE) {
            Home()
        }
    }
}
