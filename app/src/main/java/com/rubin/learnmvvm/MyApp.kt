package com.rubin.learnmvvm

import android.app.Application
import com.rubin.learnmvvm.di.appModule
import com.rubin.learnmvvm.di.networkModule
import com.rubin.learnmvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(
                listOf(
                    networkModule,
                    appModule,
                    viewModelModule
                )
            )
        }
    }
}