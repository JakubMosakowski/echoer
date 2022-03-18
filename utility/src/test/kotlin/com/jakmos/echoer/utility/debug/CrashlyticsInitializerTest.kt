package com.jakmos.echoer.utility.debug

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.jakmos.echoer.utility.debug.crashlytics.CrashlyticsInitializer
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class CrashlyticsInitializerTest {

    private val mockFirebaseCrashlytics = mockk<FirebaseCrashlytics>(relaxUnitFun = true)
    private val initializer = CrashlyticsInitializer(mockFirebaseCrashlytics)

    @Test
    fun `when initialize was called with true flag, then initializes crashlytics`() {
        initializer.initialize(true)

        verify {
            mockFirebaseCrashlytics.setCrashlyticsCollectionEnabled(true)
        }
    }

    @Test
    fun `when initialize was called with false flag, then doesn't initialize crashlytics`() {
        initializer.initialize(false)

        verify {
            mockFirebaseCrashlytics.setCrashlyticsCollectionEnabled(false)
        }
    }
}
