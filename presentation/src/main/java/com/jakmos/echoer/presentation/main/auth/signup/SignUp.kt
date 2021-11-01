package com.jakmos.echoer.presentation.main.auth.signup

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jakmos.echoer.presentation.common.theme.EchoerTheme
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect.OpenHome
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpState
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpState.Initial
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun SignUp(
    viewModel: SignUpViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    openHome: () -> Unit
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val sideEffectFlow = viewModel.container.sideEffectFlow

    LaunchedEffect(viewModel, scaffoldState.snackbarHostState) {
        launch {
            sideEffectFlow.collectLatest { handleSideEffect(it, openHome) }
        }
    }

    SignUp(
        state,
        scaffoldState,
        viewModel::onTextClicked
    )
}

@Composable
private fun SignUp(
    state: SignUpState = Initial,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onClick: () -> Unit = {}
) = Scaffold(scaffoldState = scaffoldState) {
    ClickableText(
        text = AnnotatedString("Sign up screen"),
        onClick = { onClick() }
    )
}

private fun handleSideEffect(
    sideEffect: SignUpSideEffect,
    openHome: () -> Unit
) = when (sideEffect) {
    OpenHome -> openHome()
}


@Preview
@Composable
fun SignUpPreview() = EchoerTheme {
    SignUp(Initial)
}
