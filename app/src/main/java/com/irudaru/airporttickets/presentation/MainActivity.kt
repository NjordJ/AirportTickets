@file:OptIn(KoinExperimentalAPI::class)

package com.irudaru.airporttickets.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.irudaru.airporttickets.presentation.ui.screens.main.MainScreen
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.core.annotation.KoinExperimentalAPI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinAndroidContext {
                MainScreen()
            }
        }
    }
}