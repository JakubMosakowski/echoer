package com.jakmos.echoer.presentation.main.auth.signup

import com.jakmos.echoer.presentation.base.BaseViewModel
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpState
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpState.Initial
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor() : BaseViewModel<SignUpState, SignUpSideEffect>() {

    override val container: Container<SignUpState, SignUpSideEffect> = container(Initial)

    sealed class SignUpState {
        object Initial : SignUpState()
        object Loading : SignUpState()
        object Error : SignUpState()
    }

    sealed class SignUpSideEffect
}
