package com.jakmos.echoer.domain.auth

import com.jakmos.echoer.domain.auth.validate.PasswordLength
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthModule {

    companion object {

        @[Provides PasswordLength]
        fun provideMinPassword(): Int = 8
    }
}
