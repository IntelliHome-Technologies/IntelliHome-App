package com.intellihome.intellihome.di


import com.intellihome.intellihome.data.network.ApiService
import com.intellihome.intellihome.data.repository.Repository
import com.intellihome.intellihome.presentation.viewmodel.MainViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single { ApiService() }
    single { Repository(get()) }
    viewModelOf(::MainViewModel)
}
