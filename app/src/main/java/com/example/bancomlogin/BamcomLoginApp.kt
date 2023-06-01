package com.example.bancomlogin

import android.app.Application
import com.example.bancomlogin.data.RestApi
import com.example.bancomlogin.data.networkModule
import com.example.bancomlogin.domain.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.java.KoinJavaComponent.getKoin

class BamcomLoginApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@BamcomLoginApp)
            modules(listOf(networkModule, domainModule, viewModelsModule))
        }
        getKoin().setProperty(RestApi.BASE_URL_NAME, RestApi.BASE_URL)
    }
}