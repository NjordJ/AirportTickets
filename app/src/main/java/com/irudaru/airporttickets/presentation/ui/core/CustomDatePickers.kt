package com.irudaru.airporttickets.presentation.ui.core

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
internal fun OneWayDatePicker() {
    val date = remember { mutableStateOf(Calendar.getInstance()) }
    val isOpen = remember { mutableStateOf(false) }
    OutlinedTextField(
        singleLine = true,
        label = {
            Text(text = "Select date")
        },
        value = "",
        onValueChange = {},
        trailingIcon = {
            IconButton(
                onClick = {
                    isOpen.value = !isOpen.value
                }
            ) {
                Icon(imageVector = Icons.Default.DateRange, contentDescription = "")
            }
        },
        modifier = Modifier.fillMaxWidth(),
    )

    if (isOpen.value) {
        CustomDatePickerDialog(
            onAccept = {
                isOpen.value = false // close dialog
            },
            onCancel = {
                isOpen.value = false //close dialog
            }
        )
    }
}

@Composable
internal fun TwoWayDatePicker() {
    val date = remember { mutableStateOf(Calendar.getInstance()) }
    val isOpen = remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(),
    ) {
        OutlinedTextField(
            singleLine = true,
            label = {
                Text(text = "Start date")
            },
            value = "",
            onValueChange = {},
            modifier = Modifier.width(150.dp),
        )
        IconButton(
            onClick = {
                isOpen.value = !isOpen.value
            }
        ) {
            Icon(imageVector = Icons.Default.DateRange, contentDescription = "")
        }
        OutlinedTextField(
            singleLine = true,
            label = {
                Text(text = "End date")
            },
            value = "",
            onValueChange = {},
            modifier = Modifier.width(150.dp),
        )
    }

    if (isOpen.value) {
        CustomDatePickerDialog(
            onAccept = {
                isOpen.value = false // close dialog
            },
            onCancel = {
                isOpen.value = false //close dialog
            }
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CustomDatePickerDialog(
    onAccept: (Long?) -> Unit,
    onCancel: () -> Unit
) {
    val state = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = { },
        confirmButton = {
            Button(onClick = { onAccept(state.selectedDateMillis) }) {
                Text("Accept")
            }
        },
        dismissButton = {
            Button(onClick = onCancel) {
                Text("Cancel")
            }
        }
    ) {
        DatePicker(state = state)
    }
}

