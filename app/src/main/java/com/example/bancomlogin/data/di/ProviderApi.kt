package com.example.bancomlogin.data.di

import com.example.bancomlogin.data.network.UserService
import retrofit2.Retrofit

fun providerUserService(retrofit: Retrofit): UserService {
    return retrofit.create(UserService::class.java)
}