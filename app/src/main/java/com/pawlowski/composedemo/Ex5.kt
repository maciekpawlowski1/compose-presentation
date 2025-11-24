package com.pawlowski.composedemo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@PreviewWithBackground
@Composable
private fun BezLayoutu() {
    Text(text = "Hello!")
    Text(text = "World")
}

@PreviewWithBackground
@Composable
private fun ZLayoutemColumn() {
    Column {
        Text(text = "Hello!")
        Text(text = "World")
    }
}

@PreviewWithBackground
@Composable
private fun ZLayoutemRow() {
    Row {
        Text(text = "Hello!")
        Text(text = "World")
    }
}

@PreviewWithBackground
@Composable
private fun ZLayoutemBox() {
    Box {
        Text(text = "Hello!".repeat(100))
        Text(text = "World")
    }
}
