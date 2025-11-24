package com.pawlowski.composedemo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@PreviewWithBackground
@Composable
fun Zadanie() {
    val count = remember { mutableStateOf(10) }
    Column {
        Text(text = count.value.toString())

        Button(onClick = {
            count.value = 10
        }) {
            Text(text = "Restart")
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000L)
            if(count.value > 0) {
                count.value -= 1
            }
        }
    }
}
