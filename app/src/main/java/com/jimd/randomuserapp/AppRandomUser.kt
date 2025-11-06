package com.jimd.randomuserapp

import android.app.Application
import com.jimd.randomuserapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class AppRandomUser:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppRandomUser)
            modules(appModule)
        }
    }
}