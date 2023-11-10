package com.jakmos.echoer.presentation.common.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.LazyThreadSafetyMode.NONE

class DefaultDispatcherProvider : DispatcherProvider {

    override val main: CoroutineDispatcher by lazy(NONE) { Dispatchers.Main.immediate }
    override val default: CoroutineDispatcher by lazy(NONE) { Dispatchers.Default }
    override val io: CoroutineDispatcher by lazy(NONE) { Dispatchers.IO }
    override val unconfined: CoroutineDispatcher by lazy(NONE) { Dispatchers.Unconfined }
}

object DispatcherProviderWrapper {

    var provider: DispatcherProvider = DefaultDispatcherProvider()
        get() {
            if (field is DefaultDispatcherProvider && isRunningTest) {
                throw IllegalStateException("Not initialized with TestDispatcherProvider")
            }
            return field
        }

    private val isRunningTest: Boolean by lazy(NONE) {
        try {
            Class.forName("org.junit.jupiter.api.Test")
            true
        } catch (e: ClassNotFoundException) {
            false
        }
    }
}
