package com.tantawy.warbabankpoc.application

import android.app.Application
import com.tantawy.warbabankpoc.di.applicationModule
import com.tantawy.warbabankpoc.di.catalogModule
import com.tantawy.warbabankpoc.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class WarbaPOCApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = this
        application = this
        startKoin {
            androidContext(this@WarbaPOCApplication)
            this.modules(
                listOf(
                    applicationModule,
                    remoteModule,
                    catalogModule
                )
            )
        }

        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var appContext: Application
        lateinit var application: WarbaPOCApplication
    }
}