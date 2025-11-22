package com.pawlowski.composedemo

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@PreviewWithBackground
@Composable
fun Ex10() {
    var dotOffset = remember { mutableStateOf(Offset(100f, 100f)) }

    Dot(
        offset = dotOffset::value,
        modifier =
            Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectDragGestures(
                        onDragStart = { pos ->
                            dotOffset.value = pos
                        },
                        onDrag = { change, _ ->
                            dotOffset.value = change.position
                        },
                    )
                },
    )
}

@Composable
private fun Dot(
    offset: () -> Offset,
    modifier: Modifier = Modifier,
) {
    val dotColor = MaterialTheme.colorScheme.primaryContainer
    Canvas(modifier = modifier.fillMaxSize()) {
        drawCircle(
            color = dotColor,
            radius = 30.dp.toPx(),
            center = offset(),
        )
    }
}
