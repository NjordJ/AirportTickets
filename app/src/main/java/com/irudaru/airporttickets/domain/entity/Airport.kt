package com.irudaru.airporttickets.domain.entity

import com.irudaru.airporttickets.data.model.AirportModel

data class Airport(
    val id: Int,
    val code: String,
    val name: String,
    val city: String,
    val cityCode: String,
    val countryCode: String,
    val regionName: String,
    val timeZoneRegionName: String,
    val utcOffsetHours: Double,
    val latitude: Double,
    val longitude: Double,
)

fun Airport.mapToAirport(): AirportModel = AirportModel(
    id = id,
    code = code,
    name = name,
    city = city,
    cityCode = cityCode,
    countryCode = countryCode,
    regionName = regionName,
    timeZoneRegionName = timeZoneRegionName,
    utcOffsetHours = utcOffsetHours,
    latitude = latitude,
    longitude = longitude,
)