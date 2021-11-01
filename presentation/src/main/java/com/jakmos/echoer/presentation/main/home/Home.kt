package com.jakmos.echoer.presentation.main.home

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
import com.jakmos.echoer.presentation.main.home.HomeViewModel.HomeSideEffect
import com.jakmos.echoer.presentation.main.home.HomeViewModel.HomeSideEffect.ShowSnack
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun Home(
    viewModel: HomeViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val sideEffectFlow = viewModel.container.sideEffectFlow

    LaunchedEffect(viewModel, scaffoldState.snackbarHostState) {
        launch {
            sideEffectFlow.collectLatest { handleSideEffect(it, scaffoldState.snackbarHostState) }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        ClickableText(
            text = AnnotatedString(state.toString()),
            onClick = { viewModel.onClick() }
        )
    }
}

private suspend fun handleSideEffect(
    sideEffect: HomeSideEffect,
    hostState: SnackbarHostState
) = when (sideEffect) {
    ShowSnack -> hostState.showSnackbar("Test snackbar")
}

@Preview
@Composable
fun HomePreview() {
    Home(viewModel = HomeViewModel())
}
