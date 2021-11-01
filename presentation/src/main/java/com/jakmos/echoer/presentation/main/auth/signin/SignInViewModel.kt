package com.jakmos.echoer.presentation.main.auth.signin

import com.jakmos.echoer.presentation.base.BaseViewModel
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInSideEffect
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInSideEffect.OpenHome
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInSideEffect.OpenResetPassword
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInSideEffect.OpenSignUp
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInState
import com.jakmos.echoer.presentation.main.auth.signin.SignInViewModel.SignInState.Initial
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor() : BaseViewModel<SignInState, SignInSideEffect>() {

    override val container: Container<SignInState, SignInSideEffect> = container(Initial)

    fun onHomeClicked() = intent { postSideEffect(OpenHome) }

    fun onSignUpClicked() = intent { postSideEffect(OpenSignUp) }

    fun onResetPasswordClicked() = intent { postSideEffect(OpenResetPassword) }

    sealed class SignInState {
        object Initial : SignInState()
        object Loading : SignInState()
        object Error : SignInState()
    }

    sealed class SignInSideEffect {
        object OpenHome : SignInSideEffect()
        object OpenResetPassword : SignInSideEffect()
        object OpenSignUp : SignInSideEffect()
    }
}
