package com.irudaru.airporttickets.domain.interfaces

import com.irudaru.airporttickets.domain.entity.Airport

interface AirportRepository {

    fun getAllAirports(): List<Airport>

    fun getAirport(id: Int): Airport
}