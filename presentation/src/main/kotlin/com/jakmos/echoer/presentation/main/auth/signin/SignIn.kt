package com.jakmos.echoer.presentation.main.auth.signin

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
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInSideEffect
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInSideEffect.OpenHome
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInSideEffect.OpenResetPassword
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInSideEffect.OpenSignUp
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInState
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInState.Initial
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun SignIn(
    viewModel: SignInViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    openHome: () -> Unit,
    openSignUp: () -> Unit,
    openResetPassword: () -> Unit
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val sideEffectFlow = viewModel.container.sideEffectFlow

    LaunchedEffect(viewModel, scaffoldState.snackbarHostState) {
        launch {
            sideEffectFlow.collectLatest {
                handleSideEffect(
                    it,
                    openHome,
                    openSignUp,
                    openResetPassword
                )
            }
        }
    }

    SignIn(
        state,
        scaffoldState,
        viewModel::onHomeClicked,
        viewModel::onSignUpClicked,
        viewModel::onResetPasswordClicked,
    )
}

@Composable
private fun SignIn(
    state: SignInState = Initial,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onHomeClicked: () -> Unit = {},
    onSignUpClicked: () -> Unit = {},
    onResetPasswordClicked: () -> Unit = {}
) = Scaffold(scaffoldState = scaffoldState) {
    Column() {
        Text("Sign in screen")
        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(
            text = AnnotatedString("To sign up"),
            onClick = { onSignUpClicked() }
        )
        Spacer(modifier = Modifier.height(5.dp))
        ClickableText(
            text = AnnotatedString("To home"),
            onClick = { onHomeClicked() }
        )
        Spacer(modifier = Modifier.height(5.dp))
        ClickableText(
            text = AnnotatedString("To reset password"),
            onClick = { onResetPasswordClicked() }
        )
    }
}

private fun handleSideEffect(
    sideEffect: SignInSideEffect,
    openHome: () -> Unit,
    openSignUp: () -> Unit,
    openResetPassword: () -> Unit
) = when (sideEffect) {
    OpenHome -> openHome()
    OpenSignUp -> openSignUp()
    OpenResetPassword -> openResetPassword()
}

@Preview
@Composable
fun SignInPreview() = EchoerTheme {
    SignIn(Initial)
}
