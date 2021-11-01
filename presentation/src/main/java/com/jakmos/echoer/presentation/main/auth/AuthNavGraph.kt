package com.jakmos.echoer.presentation.main.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.jakmos.echoer.presentation.main.MainDestinations.AUTH_ROUTE
import com.jakmos.echoer.presentation.main.auth.AuthDestinations.HOME_ROUTE
import com.jakmos.echoer.presentation.main.auth.AuthDestinations.SIGN_UP_ROUTE
import com.jakmos.echoer.presentation.main.auth.signup.SignUp
import com.jakmos.echoer.presentation.main.home.addHomeGraph


enum class AuthDestinations {
    SIGN_UP_ROUTE,
    HOME_ROUTE
}

fun NavGraphBuilder.addAuthGraph(navController: NavController) = navigation(
    route = AUTH_ROUTE.toString(),
    startDestination = SIGN_UP_ROUTE.toString()
) {
    addSignUpScreen(navController)
    addHomeGraph()
}

private fun NavGraphBuilder.addSignUpScreen(
    navController: NavController
) = composable(SIGN_UP_ROUTE.toString()) {
    SignUp(openHome = navController::openHome)
}

private fun NavController.openHome() = navigate(HOME_ROUTE.toString()) {
    popUpTo(AUTH_ROUTE.toString())
}
