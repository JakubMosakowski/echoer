package com.jakmos.echoer.domain.auth.interactor

import com.jakmos.echoer.domain.auth.validate.EmailValidator
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ValidateEmailUseCaseTest {

    private val mockEmailValidator = mockk<EmailValidator>()
    private val useCase = ValidateEmailUseCase(mockEmailValidator)

    @Test
    fun `when proper email is passed return true`() {
        val validEmail = "something@gmail.com"
        every { mockEmailValidator.validate(validEmail) } returns true

        val result = useCase(validEmail)

        assertTrue(result)
    }

    @Test
    fun `when incorrect email is passed return false`() {
        val invalidEmail = "something@gmailcom"
        every { mockEmailValidator.validate(invalidEmail) } returns false

        val result = useCase(invalidEmail)

        assertFalse(result)
    }
}
