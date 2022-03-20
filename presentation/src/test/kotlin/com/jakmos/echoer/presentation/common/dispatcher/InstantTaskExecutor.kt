package com.jakmos.echoer.presentation.common.dispatcher

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class InstantTaskExecutor : BeforeAllCallback, AfterAllCallback {

    init {
        DispatcherProviderWrapper.provider = TestDispatcherProvider
    }

    override fun beforeAll(context: ExtensionContext?) {
        Dispatchers.setMain(TestDispatcherProvider.testDispatcher)
    }

    override fun afterAll(context: ExtensionContext?) {
        Dispatchers.resetMain()
    }
}
