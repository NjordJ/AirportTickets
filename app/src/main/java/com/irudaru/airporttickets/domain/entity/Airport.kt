package com.irudaru.airporttickets.domain.entity

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