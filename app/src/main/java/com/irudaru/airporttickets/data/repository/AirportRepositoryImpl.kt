package com.irudaru.airporttickets.data.repository

import com.irudaru.airporttickets.data.local.dao.AirportDao
import com.irudaru.airporttickets.data.model.mapToAirport
import com.irudaru.airporttickets.domain.entity.Airport
import kotlinx.coroutines.flow.firstOrNull
import org.koin.core.annotation.Single

@Single
class AirportRepositoryImpl(private val dao: AirportDao) {

    suspend fun getAllAirports(): List<Airport> {
        return dao.getAll().firstOrNull()?.map { it.mapToAirport() }
            ?: throw RuntimeException(AIRPORTS_NOT_FOUND_EXCEPTION)
    }

    suspend fun getAirportById(id: Int): Airport {
        return dao.getById(id = id).firstOrNull()?.mapToAirport()
            ?: throw RuntimeException(AIRPORT_NOT_FOUND_EXCEPTION)
    }

    companion object {
        private const val AIRPORTS_NOT_FOUND_EXCEPTION = "Airports not found"
        private const val AIRPORT_NOT_FOUND_EXCEPTION = "Airport not found"
    }
}