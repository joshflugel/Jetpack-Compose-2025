package com.josh25.uitestsjetpackcompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

// A component used ony for UI Testing exercises
@Preview
@Composable
fun JoshComponent() {
    var name by rememberSaveable { mutableStateOf("josh") }

    Column(Modifier.fillMaxSize()) {
        Text("josh", Modifier.testTag("component1"))
        Text("JOSH", Modifier.testTag("component2"))

        TextField(value = name, onValueChange = { name = it }, Modifier.testTag("textfield"))
        Text("Te llamas $name", Modifier.testTag("tellamas"))
        Button(onClick = {}, Modifier.testTag("button")) {
            Text("Button")
        }

        Image(imageVector = Icons.Default.Add, contentDescription = "superImage")

        println("JoshComponent is rendering!")
    }
}