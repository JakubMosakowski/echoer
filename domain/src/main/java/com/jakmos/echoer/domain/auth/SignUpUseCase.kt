package com.jakmos.echoer.domain.auth

import com.jakmos.echoer.data.auth.AuthRepository
import com.jakmos.echoer.utility.common.Email
import com.jakmos.echoer.utility.common.Password
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(email: Email, password: Password) =
        repository.signUp(email, password)
}

