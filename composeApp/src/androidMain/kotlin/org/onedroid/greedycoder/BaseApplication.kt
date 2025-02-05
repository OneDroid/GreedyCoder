package org.onedroid.greedycoder

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.onedroid.greedycoder.core.injection.initKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BaseApplication)
        }
    }
}