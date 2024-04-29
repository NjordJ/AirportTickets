package com.irudaru.airporttickets.domain.usecase

import com.irudaru.airporttickets.domain.interfaces.AirportRepository
import org.koin.core.annotation.Factory

@Factory
class GetAllAirportsUseCase(private val repository: AirportRepository) {
    operator fun invoke() = repository.getAllAirports()
}