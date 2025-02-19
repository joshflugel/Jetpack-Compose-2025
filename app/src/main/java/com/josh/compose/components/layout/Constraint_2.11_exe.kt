package com.josh.compose.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun Constraint_2_11_exe_preview() {
    Constraint_2_11_exe_wrapper()
}

@Composable
fun Constraint_2_11_exe_wrapper() {
    Constraint_2_11_exe(Modifier.padding((16.dp)))
}

@Composable
fun Constraint_2_11_exe (modifier: Modifier) {
    Column {
        Box(Modifier.fillMaxWidth().weight(1f).background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Text(text="Ejemplo 1")
        }
        Spacer(Modifier.height(20.dp))
        Row(Modifier.fillMaxWidth().weight(1f)) {
            Box(Modifier.fillMaxHeight().weight(1f).background(Color.Red),
                contentAlignment = Alignment.Center) {
                Text(text="Ejemplo 2")
            }
            Spacer(Modifier.width(20.dp))
            Box(Modifier.fillMaxHeight().weight(1f).background(Color.Green),
                contentAlignment = Alignment.Center) {
                Text(text="Ejemplo 3")
            }
        }
        Spacer(Modifier.height(20.dp))
        Box(Modifier.fillMaxWidth().weight(1f).background(Color.Magenta),
            contentAlignment = Alignment.Center) {
            Text(text="Ejemplo 4")
        }
    }

}