package com.josh.compose.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Example, hello $name!",
        modifier = modifier
    )
}