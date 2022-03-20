package com.jakmos.echoer.data.auth.validate

import android.util.Patterns
import com.jakmos.echoer.domain.auth.validate.EmailValidator
import javax.inject.Inject

class EmailValidatorImpl @Inject constructor() : EmailValidator {

    override fun validate(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
