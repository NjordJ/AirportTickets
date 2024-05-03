package com.irudaru.airporttickets.domain.usecase

import com.irudaru.airporttickets.domain.interfaces.AirportRepository
import org.koin.core.annotation.Factory
import org.koin.core.annotation.InjectedParam

@Factory
class GetAllAirportsUseCase(@InjectedParam private val repository: AirportRepository) {
    operator fun invoke() = repository.getAllAirports()
}