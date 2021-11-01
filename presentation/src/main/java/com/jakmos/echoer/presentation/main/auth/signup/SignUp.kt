package com.jakmos.echoer.presentation.main.auth.signup

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jakmos.echoer.presentation.common.theme.EchoerTheme
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpState
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpState.Initial


@Composable
fun SignUp(
    viewModel: SignUpViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val sideEffectFlow = viewModel.container.sideEffectFlow

    SignUp(
        state,
        scaffoldState
    )
}

@Composable
private fun SignUp(
    state: SignUpState,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) = Scaffold(scaffoldState = scaffoldState) { Text("Sign up view") }


@Preview
@Composable
fun SignUpPreview() = EchoerTheme {
    SignUp(Initial)
}
