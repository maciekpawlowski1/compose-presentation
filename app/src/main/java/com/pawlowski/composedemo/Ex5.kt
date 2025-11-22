package com.pawlowski.composedemo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@PreviewWithBackground
@Composable
private fun `Bez Layoutu`() {
    Text(text = "Hello!")
    Text(text = "World")
}

@PreviewWithBackground
@Composable
private fun `Z Layoutem Column`() {
    Column {
        Text(text = "Hello!")
        Text(text = "World")
    }
}

@PreviewWithBackground
@Composable
private fun `Z Layoutem Row`() {
    Row {
        Text(text = "Hello!")
        Text(text = "World")
    }
}

@PreviewWithBackground
@Composable
private fun `Z Layoutem Box`() {
    Box {
        Text(text = "Hello!".repeat(100))
        Text(text = "World")
    }
}
