package com.josh.compose.components.layout

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
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