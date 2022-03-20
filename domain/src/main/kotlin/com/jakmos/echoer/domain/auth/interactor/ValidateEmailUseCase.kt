package com.jakmos.echoer.domain.auth.interactor

import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor(
    private val validateEmail: (String) -> Boolean
) {

    operator fun invoke(email: String): Boolean =
        validateEmail(email)
}
