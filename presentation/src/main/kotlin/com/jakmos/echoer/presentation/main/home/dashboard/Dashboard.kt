package com.jakmos.echoer.presentation.main.home.dashboard

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jakmos.echoer.presentation.common.theme.EchoerTheme
import com.jakmos.echoer.presentation.main.home.dashboard.DashboardViewModel.DashboardSideEffect
import com.jakmos.echoer.presentation.main.home.dashboard.DashboardViewModel.DashboardSideEffect.ShowSnack
import com.jakmos.echoer.presentation.main.home.dashboard.DashboardViewModel.DashboardState
import com.jakmos.echoer.presentation.main.home.dashboard.DashboardViewModel.DashboardState.Loading
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun Dashboard(
    viewModel: DashboardViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val sideEffectFlow = viewModel.container.sideEffectFlow

    LaunchedEffect(viewModel, scaffoldState.snackbarHostState) {
        launch {
            sideEffectFlow.collectLatest { handleSideEffect(it, scaffoldState.snackbarHostState) }
        }
    }

    Dashboard(
        state,
        scaffoldState,
        viewModel::onClick
    )
}

@Composable
private fun Dashboard(
    state: DashboardState,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onClick: () -> Unit = {}
) = Scaffold(scaffoldState = scaffoldState) {
    ClickableText(
        text = AnnotatedString("Home Screen"),
        onClick = { onClick() }
    )
}

private suspend fun handleSideEffect(
    sideEffect: DashboardSideEffect,
    hostState: SnackbarHostState
) = when (sideEffect) {
    ShowSnack -> hostState.showSnackbar("Test snackbar")
}

@Preview
@Composable
fun DashboardPreview() = EchoerTheme {
    Dashboard(Loading)
}
