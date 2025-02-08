package org.onedroid.greedycoder.core.injection

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import org.onedroid.greedycoder.core.data.datastore.dataStorePreferences

actual val platformModule: Module = module {
    single<HttpClientEngine> { OkHttp.create() }
    singleOf(::dataStorePreferences)
}