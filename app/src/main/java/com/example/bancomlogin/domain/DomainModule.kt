package com.example.bancomlogin.domain

import com.example.bancomlogin.domain.usecase.GetUsersUseCase
import org.koin.dsl.module

val domainModule = module {

    single { GetUsersUseCase(get()) }
}