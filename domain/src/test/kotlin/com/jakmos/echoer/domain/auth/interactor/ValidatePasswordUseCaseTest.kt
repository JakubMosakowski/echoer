package com.jakmos.echoer.domain.auth.interactor

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class ValidatePasswordUseCaseTest {

    private val minLength = 5
    private val useCase = ValidatePasswordUseCase(minLength)

    @Test
    fun `when empty password is passed then it's incorrect`() {
        val emptyPassword = ""

        val result = useCase(emptyPassword)

        assertFalse(result)
    }

    @Test
    fun `when too short password is passed then it's incorrect`() {
        val tooShortPassword = "AB"

        val result = useCase(tooShortPassword)

        assertFalse(result)
    }

    @Test
    fun `when password with the same length as min length is passed then it is correct`() {
        val exactLongPassword = "ABCDE"

        val result = useCase(exactLongPassword)

        assertTrue(result)
    }

    @Test
    fun `when password with length greater than min is passed then it is correct`() {
        val longPassword = "Super super super long password"

        val result = useCase(longPassword)

        assertTrue(result)
    }
}
