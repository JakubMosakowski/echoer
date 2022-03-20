package com.jakmos.echoer.data.auth

import com.google.firebase.auth.FirebaseAuth
import com.jakmos.echoer.data.auth.validate.EmailValidatorImpl
import com.jakmos.echoer.domain.auth.AuthRepository
import com.jakmos.echoer.domain.auth.validate.EmailValidator
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    @Binds
    abstract fun bindAuthRepository(
        repository: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    abstract fun bindEmailValidator(
        validator: EmailValidatorImpl
    ): EmailValidator

    companion object {

        @Provides
        fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()
    }
}
