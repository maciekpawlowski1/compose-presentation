package com.pawlowski.composedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@PreviewWithBackground
@Composable
private fun Ex7() {
    Column(
        modifier =
            Modifier
                .padding(all = 16.dp)
                .background(color = Color.Blue)
                .clickable { /* ... */ }
                .fillMaxWidth(),
    ) {
        Text(text = "Text 1")
        Text(text = "Text 2")
    }
}

@PreviewWithBackground
@Composable
fun Ex7v2() {
    Column(
        modifier =
            Modifier
                .clickable { /* ... */ }
                .padding(all = 16.dp)
                .background(color = Color.Blue)
                .fillMaxWidth(),
    ) {
        Text(text = "Text 1")
        Text(text = "Text 2")
    }
}