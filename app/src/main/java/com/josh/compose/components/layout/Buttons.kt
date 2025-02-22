package com.josh.compose.components.layout

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyButtons_preview() {
    MyButtons_wrapper()
}

@Composable
fun MyButtons_wrapper() {
    MyButtons(Modifier.padding((16.dp)))
}

// 12.57 Buttons with States
@Preview
@Composable
fun MyButtonExample() {
    // var enabled = true Not like this, It's a Pitfall
    var enabled by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enabled = false},
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text("Hello")
        }

        // 12.58
        OutlinedButton(
            onClick = { enabled = false},
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Blue,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Gray
            )
        ) {
            Text("Hello OutlinedButton")
        }

        // 12.59
        TextButton(onClick = {}) {
            Text("TextButton")
        }
    }
}

@Composable
fun MyButtons(modifier: Modifier) {
    Column (modifier = Modifier){
        Button(onClick = { Log.i("joshtag", "Boton Pulsado")},
            enabled = true,
            shape = RoundedCornerShape(20),
            border = BorderStroke(4.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.White,
                disabledContainerColor = Color.Yellow,
                disabledContentColor = Color.Green
            )
        ) {
            Text("Click me")
        }

        // Outlined buttons are MEDIUM-EMPHASIS buttons. They contain actions that are important
        // but not the primary action of the app. they pair well with Buttons to indicate an
        // alternative secondary action
        OutlinedButton(onClick = {}, colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Blue
        )) {
            Text("Outlined")
        }

        // TextButtons are for LESS-PRONOUNCED actions
        TextButton(onClick = {}) {
            Text("TextButton")
        }

    }
}