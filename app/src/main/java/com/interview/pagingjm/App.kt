package com.interview.pagingjm

import android.app.Application
import com.interview.pagingjm.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                Modules.getCloudModule(),
                Modules.getApiModule(),
                Modules.postPagingDataSourceModule
            )
        }
    }
}