package com.jakmos.echoer.presentation.main.auth.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jakmos.echoer.presentation.R
import com.jakmos.echoer.presentation.common.component.BottomLoader
import com.jakmos.echoer.presentation.common.component.EchoerButton
import com.jakmos.echoer.presentation.common.component.EchoerTextInput
import com.jakmos.echoer.presentation.common.component.PasswordTextInput
import com.jakmos.echoer.presentation.common.theme.EchoerTheme
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect.OpenHome
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect.OpenSignIn
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect.ShowError
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun SignUp(
    viewModel: SignUpViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    openHome: () -> Unit,
    openSignIn: () -> Unit
) {
    val state by viewModel.container.stateFlow.collectAsState()
    val sideEffectFlow = viewModel.container.sideEffectFlow

    LaunchedEffect(viewModel, scaffoldState.snackbarHostState) {
        launch {
            handleSideEffect(
                sideEffectFlow,
                scaffoldState.snackbarHostState,
                openHome,
                openSignIn
            )
        }
    }

    SignUp(
        state,
        scaffoldState,
        onSignInClicked = viewModel::onSignInClicked,
        onSubmitClicked = viewModel::onSubmitClicked,
        onEmailChanged = viewModel::onEmailChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onConfirmPasswordChanged = viewModel::onConfirmPasswordChanged,
    )
}

@Composable
private fun SignUp(
    state: SignUpState,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onSignInClicked: () -> Unit = {},
    onSubmitClicked: () -> Unit = {},
    onEmailChanged: (String) -> Unit = {},
    onPasswordChanged: (String) -> Unit = {},
    onConfirmPasswordChanged: (String) -> Unit = {},
) = Scaffold(scaffoldState = scaffoldState) {
    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp)
    ) {
        Text(stringResource(R.string.signUp_title), modifier = Modifier.padding(12.dp))
        Text(
            stringResource(R.string.signUp_subtitle),
            modifier = Modifier
                .padding(12.dp)
                .align(CenterHorizontally)
        )

        EchoerTextInput(
            onValueChange = onEmailChanged,
            label = { Text(stringResource(R.string.signUp_email_hint)) }
        )
        PasswordTextInput(
            onValueChange = onPasswordChanged,
            label = { Text(stringResource(R.string.signUp_password_hint)) }
        )
        PasswordTextInput(
            onValueChange = onConfirmPasswordChanged,
            label = { Text(stringResource(R.string.signUp_confirm_password_hint)) }
        )
        EchoerButton(
            text = stringResource(R.string.common_submit),
            onClick = onSubmitClicked,
            enabled = state.isButtonEnabled
        )

        Spacer(modifier = Modifier.weight(1f))

        TextButton(onClick = onSignInClicked) {
            Text(stringResource(R.string.signUp_link_to_sign_in))
        }
    }

    BottomLoader(state.isLoading)
}

private suspend fun handleSideEffect(
    sideEffectFlow: Flow<SignUpSideEffect>,
    hostState: SnackbarHostState,
    openHome: () -> Unit,
    openSignIn: () -> Unit,
) = sideEffectFlow.collectLatest { sideEffect ->
    when (sideEffect) {
        OpenHome -> openHome()
        OpenSignIn -> openSignIn()
        is ShowError -> hostState.showSnackbar(sideEffect.errorText)
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview(@PreviewParameter(SignUpStateProvider::class) state: SignUpState) {
    EchoerTheme { SignUp(state) }
}

class SignUpStateProvider : PreviewParameterProvider<SignUpState> {
    override val values: Sequence<SignUpState> = sequenceOf(
        SignUpState(isButtonEnabled = false, isLoading = false),
        SignUpState(isButtonEnabled = true, isLoading = false),
        SignUpState(isButtonEnabled = false, isLoading = true)
    )
}
