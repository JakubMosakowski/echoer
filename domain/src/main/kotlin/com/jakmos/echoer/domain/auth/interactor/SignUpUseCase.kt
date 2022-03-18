package com.jakmos.echoer.domain.auth.interactor

import com.jakmos.echoer.domain.auth.AuthRepository
import com.jakmos.echoer.domain.common.Email
import com.jakmos.echoer.domain.common.Password
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(email: String, password: String) =
        repository.signUp(Email(email), Password(password))
}
