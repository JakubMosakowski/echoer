package com.jakmos.echoer.domain.auth.interactor

import com.jakmos.echoer.domain.auth.validate.PasswordLength
import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor(
    @PasswordLength
    private val minPasswordLength: Int
) {

    operator fun invoke(password: String): Boolean =
        password.length >= minPasswordLength
}
