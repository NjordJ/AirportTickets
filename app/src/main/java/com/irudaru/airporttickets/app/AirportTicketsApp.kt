package com.irudaru.airporttickets.app

import android.app.Application
import com.irudaru.airporttickets.data.local.database.DatabaseModule
import com.irudaru.airporttickets.presentation.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

class AirportTicketsApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AirportTicketsApp)
            modules(AppModule().module, DatabaseModule().module)
        }
    }
}