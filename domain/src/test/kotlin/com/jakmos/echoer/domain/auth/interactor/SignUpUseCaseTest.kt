package com.jakmos.echoer.domain.auth.interactor

import com.jakmos.echoer.domain.auth.AuthRepository
import com.jakmos.echoer.domain.common.Email
import com.jakmos.echoer.domain.common.Password
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

internal class SignUpUseCaseTest {

    private val mockRepository = mockk<AuthRepository>(relaxed = true)
    private val useCase = SignUpUseCase(mockRepository)

    @Test
    fun `when sign up use case invoked then run sign up on repository with correct parameters`() =
        runTest {
            val email = "email"
            val password = "password"

            useCase(email, password)

            coVerify {
                mockRepository.signUp(Email(email), Password(password))
            }
        }
}
