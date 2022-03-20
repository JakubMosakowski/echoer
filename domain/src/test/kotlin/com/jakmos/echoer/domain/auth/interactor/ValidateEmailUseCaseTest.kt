package com.jakmos.echoer.domain.auth.interactor

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ValidateEmailUseCaseTest {

    private val mockValidator = mockk<(String) -> Boolean>()
    private val useCase = ValidateEmailUseCase(mockValidator)

    @Test
    fun `when proper email is passed return true`() {
        val validEmail = "something@gmail.com"
        every { mockValidator.invoke(any()) } returns true

        val result = useCase(validEmail)

        assertTrue(result)
    }

    @Test
    fun `when incorrect email is passed return false`() {
        val invalidEmail = "something@gmailcom"
        every { mockValidator.invoke(any()) } returns false

        val result = useCase(invalidEmail)

        assertFalse(result)
    }
}
