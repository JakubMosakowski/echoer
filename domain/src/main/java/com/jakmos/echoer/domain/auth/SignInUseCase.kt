package com.jakmos.echoer.domain.auth

import com.jakmos.echoer.data.auth.AuthRepository
import com.jakmos.echoer.utility.common.Email
import com.jakmos.echoer.utility.common.Password
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(email: Email, password: Password) =
        repository.signIn(email, password)
}

