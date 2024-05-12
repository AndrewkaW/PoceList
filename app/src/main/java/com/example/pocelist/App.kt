package com.example.pocelist

import android.app.Application
import com.example.pocelist.di.dataModule
import com.example.pocelist.di.repositoryModule
import com.example.pocelist.di.useCasesModule
import com.example.pocelist.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, repositoryModule, useCasesModule, viewModelModule)
        }
    }
}