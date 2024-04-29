package com.irudaru.airporttickets.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.irudaru.airporttickets.data.local.dao.AirportDao
import com.irudaru.airporttickets.data.model.AirportModel
import org.koin.core.annotation.Single

private const val PATH_TO_DB_ASSET = "database/airports.db"
private const val ROOM_DB_NAME = "airports_app.db"

@Single
@Database(
    entities = [
        AirportModel::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun airportDao(): AirportDao

    companion object : SingletonHolder<AppDatabase, Context>({
        Room.databaseBuilder(it.applicationContext, AppDatabase::class.java, ROOM_DB_NAME)
            .createFromAsset(PATH_TO_DB_ASSET)
            .build()
    })
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