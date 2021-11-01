package com.jakmos.echoer.presentation.main.auth.signup

import android.content.res.Resources
import android.util.Patterns
import com.jakmos.echoer.domain.auth.SignUpUseCase
import com.jakmos.echoer.presentation.base.BaseViewModel
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpSideEffect.OpenSignIn
import com.jakmos.echoer.presentation.main.auth.signup.SignUpViewModel.SignUpState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: SignUpUseCase,
    private val resources: Resources
) : BaseViewModel<SignUpState, SignUpSideEffect>() {

    private var email: String = ""
        set(value) {
            field = value
            validate()
        }

    private var password: String = ""
        set(value) {
            field = value
            validate()
        }

    private var confirmPassword: String = ""
        set(value) {
            field = value
            validate()
        }

    override val container: Container<SignUpState, SignUpSideEffect> =
        container(SignUpState())

    fun onEmailChanged(email: String) {
        this.email = email
    }

    fun onPasswordChanged(password: String) {
        this.password = password
    }

    fun onConfirmPasswordChanged(confirmPassword: String) {
        this.confirmPassword = confirmPassword
    }

    fun onSubmitClicked() {
        Timber.v("On Submit clicked $email $password $confirmPassword")
    }

    private fun validate() {
        val isButtonEnabled = isEmailValid() && isPasswordValid()

        intent {
            reduce {
                state.copy(isButtonEnabled = isButtonEnabled)
            }
        }
    }

    private fun isEmailValid(): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isPasswordValid(): Boolean =
        password == confirmPassword && password.length >= PASSWORD_MIN_LENGTH

    fun onSignInClicked() = intent { postSideEffect(OpenSignIn) }

    data class SignUpState(
        val isLoading: Boolean = false,
        val isButtonEnabled: Boolean = false
    )

    sealed class SignUpSideEffect {
        object OpenHome : SignUpSideEffect()
        object OpenSignIn : SignUpSideEffect()
        data class ShowError(val errorText: String) : SignUpSideEffect()
    }

    companion object {
        const val PASSWORD_MIN_LENGTH = 8
    }
}
