package com.irudaru.airporttickets.presentation.ui.screens.ticketchoose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.irudaru.airporttickets.R
import com.irudaru.airporttickets.presentation.ui.core.OneWayDatePicker
import com.irudaru.airporttickets.presentation.ui.core.TwoWayDatePicker

@Composable
fun TicketChooseScreen() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(8.dp),
    ) {
        ChooseDateAndDirection(
            modifier = Modifier.padding(horizontal = 4.dp),
        )
    }
}

@Composable
private fun ChooseDateAndDirection(
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        Column {
            val checkedState = remember { mutableStateOf(false) }
            Row {
                when (checkedState.value) {
                    true -> {
                        OneWayDatePicker()
                    }

                    false -> {
                        TwoWayDatePicker()
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(R.string.is_one_way_checkbox),
                )
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                )
            }
        }
    }
}