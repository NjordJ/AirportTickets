package com.irudaru.airporttickets.domain.usecase

import com.irudaru.airporttickets.domain.interfaces.AirportRepository
import org.koin.core.annotation.Factory

@Factory
class GetAirportUseCase(private val repository: AirportRepository) {
    operator fun invoke(id: Int) = repository.getAirport(id = id)
}