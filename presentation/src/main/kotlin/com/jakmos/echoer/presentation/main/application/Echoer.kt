package com.jakmos.echoer.presentation.main.application

import android.app.Application
import com.jakmos.echoer.BuildConfig
import com.jakmos.echoer.utility.debug.CrashlyticsInitializer
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class Echoer : Application() {

    @Inject
    lateinit var crashlyticsInitializer: CrashlyticsInitializer

    override fun onCreate() {
        super.onCreate()

        setupTimber()
        setupCrashlytics()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun setupCrashlytics() =
        crashlyticsInitializer.initialize(BuildConfig.ENABLE_CRASHLYTICS)
}
