package com.jakmos.echoer.utility.debug

import com.google.firebase.crashlytics.FirebaseCrashlytics
import javax.inject.Inject

class CrashlyticsInitializer @Inject constructor() {

    fun initialize(enabled: Boolean) =
        FirebaseCrashlytics
            .getInstance()
            .setCrashlyticsCollectionEnabled(enabled)
}
