package com.jakmos.echoer.utility.debug.crashlytics

import com.google.firebase.crashlytics.FirebaseCrashlytics
import javax.inject.Inject

class CrashlyticsInitializer @Inject constructor(
    private val firebaseCrashlytics: FirebaseCrashlytics
) {

    fun initialize(enabled: Boolean) =
        firebaseCrashlytics
            .setCrashlyticsCollectionEnabled(enabled)
}
