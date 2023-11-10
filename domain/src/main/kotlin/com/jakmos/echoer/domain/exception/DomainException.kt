package com.jakmos.echoer.domain.exception

import java.lang.Exception

abstract class DomainException(override val message: String?) : RuntimeException()

class UnauthorizedException : DomainException(null)

class UnknownException(override val cause: Exception? = null) : DomainException(null)
