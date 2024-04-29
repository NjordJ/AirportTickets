package com.irudaru.airporttickets.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.irudaru.airporttickets.domain.entity.Airport

@Entity(tableName = "Airports")
data class AirportModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "city_code") val cityCode: String,
    @ColumnInfo(name = "country_code") val countryCode: String,
    @ColumnInfo(name = "region_name") val regionName: String,
    @ColumnInfo(name = "time_zone_region_name") val timeZoneRegionName: String,
    @ColumnInfo(name = "utc_offset_hours") val utcOffsetHours: Double,
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "longitude") val longitude: Double,
)

fun AirportModel.mapToAirport(): Airport = Airport(
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