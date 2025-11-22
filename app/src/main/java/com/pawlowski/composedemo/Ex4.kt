package com.pawlowski.composedemo

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

@Composable
private fun Counter(
    count: Int,
    onIncrement: () -> Unit,
) {
    Button(onClick = onIncrement) {
        Text("Count: $count")
    }
}

class ViewModelEx4 : ViewModel() {
    val count = MutableStateFlow(0)

    fun increment() {
        count.update { it + 1 }
    }
}

@Preview(showBackground = true)
@Composable
fun Ex4() {
    val viewModel = viewModel<ViewModelEx4>()
    val count by viewModel.count.collectAsStateWithLifecycle()
    Counter(
        count = count,
        onIncrement = {
            viewModel.increment()
        },
    )
}
