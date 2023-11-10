package com.jakmos.echoer.domain.auth.interactor

import com.jakmos.echoer.domain.auth.validate.EmailValidator
import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor(
    private val emailValidator: EmailValidator
) {

    operator fun invoke(email: String): Boolean =
        emailValidator.validate(email)
}
