package com.jakmos.echoer.presentation.main.application

import android.app.Application
import com.jakmos.echoer.BuildConfig
import com.jakmos.echoer.utility.debug.CrashlyticsInitialiser
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import javax.inject.Inject

@HiltAndroidApp
class MainApplication : Application() {

    @Inject
    lateinit var crashlyticsInitialiser: CrashlyticsInitialiser

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
        crashlyticsInitialiser.initialize(BuildConfig.ENABLE_CRASHLYTICS)

}

