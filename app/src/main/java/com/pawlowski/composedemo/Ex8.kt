package com.pawlowski.composedemo

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@PreviewWithBackground
@Composable
private fun Ex8() {
    var visible by remember {
        mutableStateOf(true)
    }
    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000),
    )
    Box(
        modifier =
            Modifier
                .size(size = 40.dp)
                .alpha(alpha)
                .background(color = Color.Red)
                .clickable {
                visible = !visible
            },
    )
}
