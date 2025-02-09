package org.onedroid.greedycoder.core.injection

import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.onedroid.greedycoder.app.presentation.home.HomeViewModel
import org.onedroid.greedycoder.app.presentation.profile.ProfileViewModel
import org.onedroid.greedycoder.app.presentation.settings.SettingViewModel
import org.onedroid.greedycoder.core.codeforces.data.network.CFRemoteDataSource
import org.onedroid.greedycoder.core.codeforces.data.network.CFRemoteDataSourceImpl
import org.onedroid.greedycoder.core.codeforces.data.repository.CFRepositoryImpl
import org.onedroid.greedycoder.core.codeforces.domain.repository.CFRepository
import org.onedroid.greedycoder.core.codeforces.domain.usecase.SearchUserUseCase
import org.onedroid.greedycoder.core.network.HttpClientFactory
import org.onedroid.greedycoder.core.utils.AppPreferences

expect val platformModule: Module
val sharedModule = module {
    single { HttpClientFactory.create(get()) }

    viewModelOf(::ProfileViewModel)
    singleOf(::CFRemoteDataSourceImpl).bind<CFRemoteDataSource>()
    singleOf(::CFRepositoryImpl).bind<CFRepository>()
    singleOf(::SearchUserUseCase)

    viewModelOf(::SettingViewModel)
    singleOf(::AppPreferences)

    viewModelOf(::HomeViewModel)
}