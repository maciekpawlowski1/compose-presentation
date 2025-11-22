package com.pawlowski.composedemo

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
private fun Counter(
    count: Int,
    onIncrement: () -> Unit,
) {
    Button(onClick = onIncrement) {
        Text("Count: $count")
    }
}

class ViewModelEx3 : ViewModel() {
    val count = mutableIntStateOf(value = 0)
}

@Preview(showBackground = true)
@Composable
fun Ex3() {
    val viewModel = viewModel<ViewModelEx3>()

    Counter(
        count = viewModel.count.intValue,
        onIncrement = {
            viewModel.count.intValue += 1
        },
    )
}
