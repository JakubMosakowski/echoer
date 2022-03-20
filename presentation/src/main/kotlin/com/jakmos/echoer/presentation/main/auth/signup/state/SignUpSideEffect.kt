package com.jakmos.echoer.presentation.main.auth.signup.state

sealed class SignUpSideEffect {
    object OpenHome : SignUpSideEffect()
    object OpenSignIn : SignUpSideEffect()
    data class ShowError(val errorText: String) : SignUpSideEffect()
}
