package com.josh.compose.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyState2_19(modifier: Modifier){
/*
    var number:String = "0"
    Text("Pulsame: $number", modifier = modifier.clickable { number+=1 })
 */

    // Can't just use values in Compose, use mutableStateOf, and pick up the .value inside:
    // Introducing: RECOMPOSITION: Repaints Composable UI Block when state changes.
    // Optimized to avoid unneccessary repainting.

    // use remember{ } to persist values after repainting, AND screen rotation
    // var number = rememberSaveable { mutableStateOf("") }
    // REPLACE = with operator BY, to cleanup code:
    // ALSO use INT in mutable state
    var number by rememberSaveable { mutableIntStateOf(0) }

    Column {
        // Text("Pulsame: ${number.value}", modifier = modifier.clickable { number.value +=1 })
        Text("Pulsame: ${number}", modifier = modifier.clickable { number +=1 })

        Text("Pulsame: ", modifier = modifier.clickable { number +=1 })
        Text("Pulsame: ", modifier = modifier.clickable { number +=1 })

        // Text("Pulsame: ${number.value}", modifier = modifier.clickable { number.value +=1 })
        Text("Pulsame: ${number}", modifier = modifier.clickable { number +=1 })

        Text("Pulsame: ", modifier = modifier.clickable { number +=1 })
    }

}