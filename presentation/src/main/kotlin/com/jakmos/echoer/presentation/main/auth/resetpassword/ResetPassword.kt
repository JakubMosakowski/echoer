package com.jakmos.echoer.presentation.main.auth.resetpassword

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
import com.jakmos.echoer.presentation.main.auth.resetpassword.ResetPasswordViewModel.ResetPasswordSideEffect
import com.jakmos.echoer.presentation.main.auth.resetpassword.ResetPasswordViewModel.ResetPasswordSideEffect.OpenSignIn
import com.jakmos.echoer.presentation.main.auth.resetpassword.ResetPasswordViewModel.ResetPasswordState
import com.jakmos.echoer.presentation.main.auth.resetpassword.ResetPasswordViewModel.ResetPasswordState.Initial
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun ResetPassword(
    viewModel: ResetPasswordViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    openSignIn: () -> Unit
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val sideEffectFlow = viewModel.container.sideEffectFlow

    LaunchedEffect(viewModel, scaffoldState.snackbarHostState) {
        launch {
            sideEffectFlow.collectLatest { handleSideEffect(it, openSignIn) }
        }
    }

    ResetPassword(
        state,
        scaffoldState,
        viewModel::onSignInClicked
    )
}

@Composable
private fun ResetPassword(
    state: ResetPasswordState = Initial,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onSignInClicked: () -> Unit = {}
) = Scaffold(scaffoldState = scaffoldState) {
    Column() {
        Text("Reset password screen")
        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(
            text = AnnotatedString("To sign in"),
            onClick = { onSignInClicked() }
        )
    }
}

private fun handleSideEffect(
    sideEffect: ResetPasswordSideEffect,
    openSignIn: () -> Unit,
) = when (sideEffect) {
    OpenSignIn -> openSignIn()
}


@Preview
@Composable
fun ResetPasswordPreview() = EchoerTheme {
    ResetPassword(Initial)
}
