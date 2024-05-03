package com.irudaru.airporttickets.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.irudaru.airporttickets.data.model.AirportModel
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single

@Dao
interface AirportDao {

    @Query("SELECT * FROM Airports")
    fun getAll(): Flow<List<AirportModel>>

    @Query("SELECT * FROM Airports WHERE id = :id")
    fun getById(id: Int): Flow<AirportModel>
}