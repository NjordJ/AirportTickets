package com.irudaru.airporttickets.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.irudaru.airporttickets.data.local.dao.AirportDao
import com.irudaru.airporttickets.data.local.database.AppDatabase.Companion.PATH_TO_DB_ASSET
import com.irudaru.airporttickets.data.local.database.AppDatabase.Companion.ROOM_DB_NAME
import com.irudaru.airporttickets.data.model.AirportModel
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Database(
    entities = [
        AirportModel::class
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun airportDao(): AirportDao

    companion object {
        const val PATH_TO_DB_ASSET = "database/airports.db"
        const val ROOM_DB_NAME = "airports_app.db"
    }
}

@Module
@ComponentScan
class DatabaseModule() {
    private var databaseInstance: AppDatabase? = null

    @Single
    fun getInstance(@InjectedParam context: Context): AppDatabase {
        return databaseInstance ?: synchronized(this) {
            databaseInstance ?: createDatabase(context).also { databaseInstance = it }
        }
    }

    private fun createDatabase(context: Context): AppDatabase {
        return SingletonHolder(::createDatabaseInstance).getInstance(context)
    }

    private fun createDatabaseInstance(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            ROOM_DB_NAME
        )
            .createFromAsset(PATH_TO_DB_ASSET)
            .build()
    }
}

open class SingletonHolder<T, A>(creator: (A) -> T) {
    private var creator: ((A) -> T)? = creator

    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T {
        val i = instance
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = instance
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}