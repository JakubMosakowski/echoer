package com.jakmos.echoer.domain.auth.validate

interface EmailValidator {

    fun validate(email: String): Boolean
}
