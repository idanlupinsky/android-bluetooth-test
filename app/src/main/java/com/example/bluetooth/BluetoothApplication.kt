package com.example.bluetooth

import android.app.Application
import com.example.bluetooth.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BluetoothApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@BluetoothApplication)
            modules(appModule)
        }
    }
}