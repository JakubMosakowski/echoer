package com.jakmos.echoer.presentation.main.home

import com.jakmos.echoer.presentation.base.BaseViewModel
import com.jakmos.echoer.presentation.main.home.HomeViewModel.HomeSideEffect
import com.jakmos.echoer.presentation.main.home.HomeViewModel.HomeSideEffect.ShowSnack
import com.jakmos.echoer.presentation.main.home.HomeViewModel.HomeState
import com.jakmos.echoer.presentation.main.home.HomeViewModel.HomeState.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel<HomeState, HomeSideEffect>() {

    override val container: Container<HomeState, HomeSideEffect> = container(Loading)

    fun onClick() = intent { postSideEffect(ShowSnack) }

    sealed class HomeState {
        object Loading : HomeState()
        object Success : HomeState()
        object Error : HomeState()
    }

    sealed class HomeSideEffect {
        object ShowSnack : HomeSideEffect()
    }
}
