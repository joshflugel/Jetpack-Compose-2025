package com.josh.compose.components.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp


// 15 Selection Control Components

@Composable // 15.71
fun MyRadioButtonList(name: String, onItemSelected:(String) -> Unit) {
    Column(Modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val title = "Beef"
            RadioButton( name == title, onClick = { onItemSelected(title) })
            Text(title)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            val title = "Chicken"
            RadioButton(name == title, onClick = { onItemSelected(title) })
            Text(title)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            val title = "BBQ Ribs"
            RadioButton(name == title, onClick = { onItemSelected(title) })
            Text(title)
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            val title = "Shrimp"
            RadioButton(name == title, onClick = { onItemSelected(title) })
            Text(title)
        }
    }
}

@Composable
fun MyRadioButton() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = false, onClick = { },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Green
            )
        )
        Text("RadioButton 1")
    }
}

@Composable // 15.69
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when(status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable // 15.68, rememberSaveable needs Composable annot.
fun getCheckboxListOfIngredients(titles: List<String>): List<CheckInfo> {
    return titles.map { // it: String
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,  // status is the value
            onCheckedChange = {newStatus -> status = newStatus} // the Boolean from the lambda defined in CheckInfo data class
        )
    }
}

@Composable // 15.68
fun MyCheckboxWithTextAdvanced(checkInfo: CheckInfo) {
    // var state by rememberSaveable { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checkInfo.selected, onCheckedChange = {checkInfo.onCheckedChange(!checkInfo.selected)})
        Spacer(modifier = Modifier.width(8.dp))
        // Text("Example 1")
        Text(checkInfo.title) // not hardcoded anymore
    }
}

@Composable // 15.67
fun MyCheckboxWithText() {
    var state by rememberSaveable { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = state, onCheckedChange = {state = !state})
        Spacer(modifier = Modifier.width(8.dp))
        Text("Example 1")
    }
}

@Composable // 15.66
fun MyCheckbox() {
    var state by rememberSaveable { mutableStateOf(false) }
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state },
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )
}

// 15.65
@Composable
fun MySwitch() {
    var state by rememberSaveable { mutableStateOf(false) }
    Text("Switch")
    Switch(
        checked = state,
        onCheckedChange = { state = !state },
        // enabled = false,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Magenta.copy(alpha = 0.1f),
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan.copy(alpha = 0.1f),
            disabledCheckedThumbColor = Color.Yellow,
            disabledCheckedTrackColor = Color.Yellow.copy(0.1f),
            disabledUncheckedThumbColor = Color.Yellow,
            disabledUncheckedTrackColor = Color.Yellow.copy(0.1f)
        )

        )

}