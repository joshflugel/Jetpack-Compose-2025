package com.josh.compose.components.layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// 17) Slider

@Composable
fun MyRangeSlider() {
    var currentRange by rememberSaveable { mutableStateOf(8f to 18f) }

    RangeSlider(
        value = currentRange.first..currentRange.second,
        onValueChange = { range->
            currentRange = range.start to range.endInclusive
        },
        valueRange = 0f..40f,
        steps = 39
    )
    Text("Min: ${currentRange.first}")
    Text("Max: ${currentRange.second}")
}

@Composable
fun MySliderAdvanced() {
    var sliderPosition by rememberSaveable { mutableFloatStateOf(0f) }
    var completeValue by rememberSaveable { mutableStateOf("") }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = { completeValue = sliderPosition.toString() },
            valueRange = 0f..10f,
            steps = 9    // 10 positions, but 1 doesn't count, so 9
        )
        Text(completeValue)
    }
}

@Composable
fun MySliderBasic() {
    var sliderPosition by rememberSaveable { mutableFloatStateOf(0f) }
    Column(horizontalAlignment = Alignment.CenterHorizontally) {  }
    Slider(sliderPosition, onValueChange = {sliderPosition = it})
    Text(sliderPosition.toString())
}