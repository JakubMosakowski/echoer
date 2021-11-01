package com.jakmos.echoer.presentation.main.auth.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jakmos.echoer.presentation.common.theme.EchoerTheme
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect.OpenHome
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect.OpenSignIn
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpState
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpState.Initial
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun SignUp(
    viewModel: SignUpViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    openHome: () -> Unit,
    openSignIn: () -> Unit
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val sideEffectFlow = viewModel.container.sideEffectFlow

    LaunchedEffect(viewModel, scaffoldState.snackbarHostState) {
        launch {
            sideEffectFlow.collectLatest { handleSideEffect(it, openHome, openSignIn) }
        }
    }

    SignUp(
        state,
        scaffoldState,
        viewModel::onSignInClicked,
        viewModel::onHomeClicked
    )
}

@Composable
private fun SignUp(
    state: SignUpState = Initial,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onSignInClicked: () -> Unit = {},
    onHomeClicked: () -> Unit = {}
) = Scaffold(scaffoldState = scaffoldState) {
    Column() {
        Text("Sign up screen")
        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(
            text = AnnotatedString("To sign in"),
            onClick = { onSignInClicked() }
        )
        Spacer(modifier = Modifier.height(5.dp))
        ClickableText(
            text = AnnotatedString("To home"),
            onClick = { onHomeClicked() }
        )
    }
}

private fun handleSideEffect(
    sideEffect: SignUpSideEffect,
    openHome: () -> Unit,
    openSignIn: () -> Unit,
) = when (sideEffect) {
    OpenHome -> openHome()
    OpenSignIn -> openSignIn()
}


@Preview
@Composable
fun SignUpPreview() = EchoerTheme {
    SignUp(Initial)
}
