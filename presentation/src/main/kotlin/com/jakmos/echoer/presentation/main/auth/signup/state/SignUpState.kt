package com.jakmos.echoer.presentation.main.auth.signup.state

data class SignUpState(
    val isLoading: Boolean = false,
    val isButtonEnabled: Boolean = false,
    val email: String = "",
    val password: String = "",
    val confirmedPassword: String = "",
)
