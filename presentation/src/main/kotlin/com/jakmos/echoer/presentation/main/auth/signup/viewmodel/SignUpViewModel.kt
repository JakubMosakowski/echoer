package com.jakmos.echoer.presentation.main.auth.signup.viewmodel

import androidx.lifecycle.ViewModel
import com.jakmos.echoer.domain.auth.interactor.SignUpUseCase
import com.jakmos.echoer.domain.auth.interactor.ValidateEmailUseCase
import com.jakmos.echoer.domain.auth.interactor.ValidatePasswordUseCase
import com.jakmos.echoer.presentation.common.flow.reduce
import com.jakmos.echoer.presentation.common.viewmodel.launchInBackground
import com.jakmos.echoer.presentation.common.viewmodel.launchInMain
import com.jakmos.echoer.presentation.main.auth.signup.state.SignUpSideEffect
import com.jakmos.echoer.presentation.main.auth.signup.state.SignUpSideEffect.OpenSignIn
import com.jakmos.echoer.presentation.main.auth.signup.state.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val validatePasswordUseCase: ValidatePasswordUseCase,
    private val validateEmailUseCase: ValidateEmailUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<SignUpState> = MutableStateFlow(SignUpState())
    val state: StateFlow<SignUpState> = _state.asStateFlow()

    private val currentState: SignUpState
        get() = _state.value

    private val _sideEffect: Channel<SignUpSideEffect> = Channel()
    val sideEffect: Flow<SignUpSideEffect> = _sideEffect.receiveAsFlow()

    init {
        launchInBackground {
            state
                .onEach(::validate)
                .launchIn(this)
        }
    }

    fun onEmailChanged(email: String) {
        _state.reduce { copy(email = email) }
    }

    fun onPasswordChanged(password: String) {
        _state.reduce { copy(password = password) }
    }

    fun onConfirmPasswordChanged(confirmedPassword: String) {
        _state.reduce { copy(confirmedPassword = confirmedPassword) }
    }

    fun onSubmitClicked() = launchInMain {
        setLoading(true)
        delay(3000)
        // TODO add proper implementation
        Timber.v("On Submit clicked ${currentState.email} ${currentState.password} ${currentState.confirmedPassword}")
        setLoading(false)
    }

    fun onSignInClicked() = launchInMain {
        _sideEffect.send(OpenSignIn)
    }

    private fun validate(state: SignUpState) = with(state) {
        val isEmailValid = validateEmailUseCase(state.email)
        val isPasswordValid = isPasswordValid(
            password = state.password,
            confirmedPassword = state.confirmedPassword
        )

        enableButton(isEmailValid && isPasswordValid)
    }

    private fun setLoading(isLoading: Boolean) =
        _state.reduce { copy(isLoading = isLoading) }

    private fun enableButton(isEnabled: Boolean) = launchInMain {
        _state.reduce { copy(isButtonEnabled = isEnabled) }
    }

    private fun isPasswordValid(password: String, confirmedPassword: String): Boolean =
        password == confirmedPassword && validatePasswordUseCase(password)
}
