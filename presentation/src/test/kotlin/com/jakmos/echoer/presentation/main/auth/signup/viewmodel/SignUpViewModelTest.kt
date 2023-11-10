package com.jakmos.echoer.presentation.main.auth.signup.viewmodel

import com.jakmos.echoer.domain.auth.interactor.SignUpUseCase
import com.jakmos.echoer.domain.auth.interactor.ValidateEmailUseCase
import com.jakmos.echoer.domain.auth.interactor.ValidatePasswordUseCase
import com.jakmos.echoer.presentation.common.dispatcher.InstantTaskExecutor
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(InstantTaskExecutor::class)
internal class SignUpViewModelTest {

    private val mockSignUpUseCase = mockk<SignUpUseCase>()
    private val mockValidatePasswordUseCase = mockk<ValidatePasswordUseCase> {
        every { this@mockk(any()) } returns true
    }
    private val mockValidateEmailUseCase = mockk<ValidateEmailUseCase>() {
        every { this@mockk(any()) } returns true
    }
    private val viewModel = SignUpViewModel(
        mockSignUpUseCase,
        mockValidatePasswordUseCase,
        mockValidateEmailUseCase
    )

    @Test
    fun `when email changed then change it in state`() {
        val expectedEmail = "New email"

        viewModel.onEmailChanged(expectedEmail)
        val result = viewModel.state.value

        assertEquals(
            expectedEmail,
            result.email
        )
    }

    @Test
    fun `when password changed then change it in state`() {
        val expectedPassword = "New password"

        viewModel.onPasswordChanged(expectedPassword)
        val result = viewModel.state.value

        assertEquals(
            expectedPassword,
            result.password
        )
    }

    @Test
    fun `when confirmed password changed then change it in state`() {
        val expectedConfirmedPassword = "New confirmed password"

        viewModel.onConfirmPasswordChanged(expectedConfirmedPassword)
        val result = viewModel.state.value

        assertEquals(
            expectedConfirmedPassword,
            result.confirmedPassword
        )
    }

    @Test
    fun `when sign in was clicked then post OpenSignIn side effect`() {
        assert(false)
    }

    @Nested
    @DisplayName("When inputs changed")
    @ExtendWith(InstantTaskExecutor::class)
    inner class WhenInputsChanged {

        @Test
        fun `and email was in incorrect format then disable submit button`() = runTest {
            every { mockValidateEmailUseCase.invoke(any()) } returns false
            val incorrectEmail = "incorrect-email"

            viewModel.onEmailChanged(incorrectEmail)

            advanceUntilIdle()
            assertFalse(viewModel.state.value.isButtonEnabled)
        }

        @Test
        fun `and password was incorrect then disable submit button`() = runTest {
            every { mockValidatePasswordUseCase.invoke(any()) } returns false
            val incorrectPassword = "incorrectPassword"

            viewModel.onPasswordChanged(incorrectPassword)
            viewModel.onConfirmPasswordChanged(incorrectPassword)

            advanceUntilIdle()
            assertFalse(viewModel.state.value.isButtonEnabled)
        }

        @Test
        fun `and password was not matching confirmed password then disable submit button`() =
            runTest {
                val correctPassword1 = "correctPassword1"
                val correctPassword2 = "correctPassword2"

                viewModel.onPasswordChanged(correctPassword1)
                viewModel.onConfirmPasswordChanged(correctPassword2)

                advanceUntilIdle()
                assertFalse(viewModel.state.value.isButtonEnabled)
            }

        @Test
        fun `and email was correct, password was long enough and matching confirmed password, then enable submit button`() =
            runTest {
                viewModel.onEmailChanged("anything")

                advanceUntilIdle()
                assertTrue(viewModel.state.value.isButtonEnabled)
            }
    }

    @Nested
    @DisplayName("When submit was clicked")
    inner class WhenSubmitWasClicked {

        @Test
        fun `then show loading`() {
            assert(false)
        }

        @Test
        fun `then sign up user`() {
            assert(false)
        }

        @Test
        fun `and sign up succeeds then hide loading`() {
            assert(false)
        }

        @Test
        fun `and sign up fails then hide loading`() {
            assert(false)
        }

        @Test
        fun `and sign up fails then show error`() {
            assert(false)
        }
    }
}
