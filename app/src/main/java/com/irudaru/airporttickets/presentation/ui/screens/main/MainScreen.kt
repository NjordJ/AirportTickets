package com.irudaru.airporttickets.presentation.ui.screens.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.irudaru.airporttickets.presentation.ui.screens.ticketchoose.TicketChooseScreen
import com.irudaru.airporttickets.presentation.ui.theme.AirportTicketsTheme

@Composable
fun MainScreen() {
    AirportTicketsTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TicketChooseScreen()
        }
    }
}