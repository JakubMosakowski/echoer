package com.jakmos.echoer.presentation.main.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.jakmos.echoer.presentation.main.MainDestinations.AUTH_ROUTE
import com.jakmos.echoer.presentation.main.auth.AuthDestinations.HOME_ROUTE
import com.jakmos.echoer.presentation.main.auth.AuthDestinations.RESET_PASSWORD_ROUTE
import com.jakmos.echoer.presentation.main.auth.AuthDestinations.SIGN_IN_ROUTE
import com.jakmos.echoer.presentation.main.auth.AuthDestinations.SIGN_UP_ROUTE
import com.jakmos.echoer.presentation.main.auth.resetpassword.ResetPassword
import com.jakmos.echoer.presentation.main.auth.signin.SignIn
import com.jakmos.echoer.presentation.main.auth.signup.SignUp
import com.jakmos.echoer.presentation.main.home.addHomeGraph


enum class AuthDestinations {
    SIGN_UP_ROUTE,
    SIGN_IN_ROUTE,
    RESET_PASSWORD_ROUTE,
    HOME_ROUTE
}

fun NavGraphBuilder.addAuthGraph(navController: NavController) = navigation(
    route = AUTH_ROUTE.toString(),
    startDestination = SIGN_UP_ROUTE.toString()
) {
    addSignUpScreen(navController)
    addSignInScreen(navController)
    addResetPasswordScreen(navController)
    addHomeGraph()
}

private fun NavGraphBuilder.addSignUpScreen(
    navController: NavController
) = composable(SIGN_UP_ROUTE.toString()) {
    SignUp(
        openHome = navController::openHome,
        openSignIn = navController::openSignIn
    )
}

private fun NavGraphBuilder.addSignInScreen(
    navController: NavController
) = composable(SIGN_IN_ROUTE.toString()) {
    SignIn(
        openHome = navController::openHome,
        openSignUp = navController::openSignUp,
        openResetPassword = navController::openResetPassword,
    )
}

private fun NavGraphBuilder.addResetPasswordScreen(
    navController: NavController
) = composable(RESET_PASSWORD_ROUTE.toString()) {
    ResetPassword(openSignIn = navController::openSignIn)
}

private fun NavController.openHome() = navigate(HOME_ROUTE.toString()) {
    popUpTo(AUTH_ROUTE.toString())
}

private fun NavController.openSignIn() = navigate(SIGN_IN_ROUTE.toString())

private fun NavController.openSignUp() = navigate(SIGN_UP_ROUTE.toString())

private fun NavController.openResetPassword() = navigate(RESET_PASSWORD_ROUTE.toString())
