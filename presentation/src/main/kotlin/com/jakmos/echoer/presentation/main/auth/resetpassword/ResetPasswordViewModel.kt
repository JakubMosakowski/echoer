package com.jakmos.echoer.presentation.main.auth.resetpassword

import androidx.lifecycle.ViewModel
import com.jakmos.echoer.presentation.main.auth.resetpassword.ResetPasswordViewModel.ResetPasswordSideEffect
import com.jakmos.echoer.presentation.main.auth.resetpassword.ResetPasswordViewModel.ResetPasswordSideEffect.OpenSignIn
import com.jakmos.echoer.presentation.main.auth.resetpassword.ResetPasswordViewModel.ResetPasswordState
import com.jakmos.echoer.presentation.main.auth.resetpassword.ResetPasswordViewModel.ResetPasswordState.Initial
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ResetPasswordViewModel @Inject constructor() :
    ContainerHost<ResetPasswordState, ResetPasswordSideEffect>, ViewModel() {

    override val container: Container<ResetPasswordState, ResetPasswordSideEffect> =
        container(Initial)

    fun onSignInClicked() = intent { postSideEffect(OpenSignIn) }

    sealed class ResetPasswordState {
        object Initial : ResetPasswordState()
        object Loading : ResetPasswordState()
        object Error : ResetPasswordState()
    }

    sealed class ResetPasswordSideEffect {
        object OpenSignIn : ResetPasswordSideEffect()
    }
}
