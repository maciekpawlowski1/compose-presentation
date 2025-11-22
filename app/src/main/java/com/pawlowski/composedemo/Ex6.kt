package com.pawlowski.composedemo

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

val LocalSpacing = compositionLocalOf { 8.dp }

@Composable
fun Ex6() {
    CompositionLocalProvider(LocalSpacing provides 16.dp) {
        Text("Spacing = ${LocalSpacing.current}")
    }
}

@Composable
private fun Osobny() {
    Text("Spacing = ${LocalSpacing.current}")
}
