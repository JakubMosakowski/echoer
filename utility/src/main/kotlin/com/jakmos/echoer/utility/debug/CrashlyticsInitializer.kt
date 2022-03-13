package com.jakmos.echoer.utility.debug

import com.google.firebase.crashlytics.FirebaseCrashlytics
import javax.inject.Inject

class CrashlyticsInitialiser @Inject constructor() {

    fun initialize(enabled: Boolean) =
        FirebaseCrashlytics
            .getInstance()
            .setCrashlyticsCollectionEnabled(enabled)

}
