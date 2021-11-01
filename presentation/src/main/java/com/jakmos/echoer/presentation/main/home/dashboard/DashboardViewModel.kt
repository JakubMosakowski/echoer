package com.jakmos.echoer.presentation.main.home.dashboard

import com.jakmos.echoer.presentation.base.BaseViewModel
import com.jakmos.echoer.presentation.main.home.dashboard.DashboardViewModel.DashboardSideEffect
import com.jakmos.echoer.presentation.main.home.dashboard.DashboardViewModel.DashboardSideEffect.ShowSnack
import com.jakmos.echoer.presentation.main.home.dashboard.DashboardViewModel.DashboardState
import com.jakmos.echoer.presentation.main.home.dashboard.DashboardViewModel.DashboardState.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : BaseViewModel<DashboardState, DashboardSideEffect>() {

    override val container: Container<DashboardState, DashboardSideEffect> = container(Loading)

    fun onClick() = intent { postSideEffect(ShowSnack) }

    sealed class DashboardState {
        object Loading : DashboardState()
        object Success : DashboardState()
        object Error : DashboardState()
    }

    sealed class DashboardSideEffect {
        object ShowSnack : DashboardSideEffect()
    }
}
