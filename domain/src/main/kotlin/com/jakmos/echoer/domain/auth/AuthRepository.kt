package com.jakmos.echoer.domain.auth

import com.jakmos.echoer.domain.common.Email
import com.jakmos.echoer.domain.common.Password

interface AuthRepository {

    suspend fun signUp(email: Email, password: Password)

    suspend fun signIn(email: Email, password: Password)
}
