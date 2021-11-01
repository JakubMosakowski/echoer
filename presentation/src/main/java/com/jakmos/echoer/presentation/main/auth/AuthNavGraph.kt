package com.jakmos.echoer.presentation.main.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.jakmos.echoer.presentation.main.auth.signup.SignUp


enum class AuthDestinations {
    SIGN_UP_ROUTE
}

fun NavGraphBuilder.authentication() {
    composable(AuthDestinations.SIGN_UP_ROUTE.toString()) {
        SignUp()
    }
}
