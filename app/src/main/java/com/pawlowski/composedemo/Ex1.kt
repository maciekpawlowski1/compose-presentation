package com.pawlowski.composedemo

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pawlowski.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeDemoTheme {
        Greeting("Android")
    }
}

// Or
@Preview(showBackground = true)
annotation class PreviewWithBackground

@PreviewWithBackground
@Composable
fun GreetingPreview2() {
    ComposeDemoTheme {
        Greeting("Android")
    }
}