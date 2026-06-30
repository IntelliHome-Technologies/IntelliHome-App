package com.intellihome.intellihome.android

import android.app.Application
import com.intellihome.intellihome.di.initKoin
import org.koin.android.ext.koin.androidContext

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@App)
        }
    }
}