package com.jakmos.echoer.domain.auth.interactor

import com.jakmos.echoer.domain.auth.AuthRepository
import com.jakmos.echoer.domain.common.Email
import com.jakmos.echoer.domain.common.Password
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(email: Email, password: Password) =
        repository.signIn(email, password)
}
