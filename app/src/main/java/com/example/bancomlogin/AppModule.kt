package com.example.bancomlogin

import com.example.bancomlogin.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    single { DispatcherProvider() }
    viewModel { HomeViewModel(get(), get()) }
}