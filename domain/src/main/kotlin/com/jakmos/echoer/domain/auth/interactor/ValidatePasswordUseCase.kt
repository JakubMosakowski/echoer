package com.jakmos.echoer.domain.auth.interactor

import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor(
    private val minPasswordLength: Int
) {

    operator fun invoke(password: String): Boolean =
        password.length >= minPasswordLength
}
