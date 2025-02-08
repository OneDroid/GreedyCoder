package org.onedroid.greedycoder.core.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import android.app.Application
import org.koin.mp.KoinPlatform
import org.onedroid.greedycoder.core.utils.DATA_STORE_FILE_NAME

actual fun dataStorePreferences(): DataStore<Preferences> {
    val appContext = KoinPlatform.getKoin().get<Application>()
    return AppSettings.getDataStore(
        producePath = {
            appContext.filesDir
                .resolve(DATA_STORE_FILE_NAME)
                .absolutePath
        }
    )
}