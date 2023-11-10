package com.jakmos.echoer.data.auth

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.jakmos.echoer.domain.common.Email
import com.jakmos.echoer.domain.common.Password
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test

internal class AuthRepositoryImplTest {

    private val mockTask = mockk<Task<AuthResult>> {
        every { isComplete } returns true
        every { isCanceled } returns false
        every { exception } returns null
        every { result } returns mockk()
    }
    private val mockFirebaseAuth = mockk<FirebaseAuth> {
        every { signInWithEmailAndPassword(any(), any()) } returns mockTask
        every { createUserWithEmailAndPassword(any(), any()) } returns mockTask
    }

    private val repository = AuthRepositoryImpl(mockFirebaseAuth)

    @Test
    fun `signs up`() = runTest {
        val email = Email("some-email")
        val password = Password("some-password")

        repository.signUp(email, password)

        verify { mockFirebaseAuth.createUserWithEmailAndPassword(email.value, password.value) }
    }

    @Test
    fun `signs in`() = runTest {
        val email = Email("some-email")
        val password = Password("some-password")

        repository.signIn(email, password)

        verify { mockFirebaseAuth.signInWithEmailAndPassword(email.value, password.value) }
    }
}
