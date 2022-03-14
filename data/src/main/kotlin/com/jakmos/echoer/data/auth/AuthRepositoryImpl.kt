package com.jakmos.echoer.data.auth

import com.google.firebase.auth.FirebaseAuth
import com.jakmos.echoer.domain.auth.AuthRepository
import com.jakmos.echoer.domain.common.Email
import com.jakmos.echoer.domain.common.Password
import kotlinx.coroutines.tasks.await
import timber.log.Timber
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRepository {

    override suspend fun signUp(email: Email, password: Password) {
        val result = auth.createUserWithEmailAndPassword(email.value, password.value).await()
        Timber.v("User created successfully: ${result.user}")
    }

    override suspend fun signIn(email: Email, password: Password) {
        val result = auth.signInWithEmailAndPassword(email.value, password.value).await()
        Timber.v("User logged in successfully: ${result.user}")
    }
}
