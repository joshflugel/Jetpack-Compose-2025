package com.josh.compose.components.layout

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// 16 OTHER COMPONENTS


@Composable // 16.76
fun MyDropdownMenu(){

    var selectedText by rememberSaveable { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }
    val desserts = listOf("Chocolate", "Coffee", "Fruit", "3 Leches")

    Text("Dropdown Menu:")
    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false },
            Modifier.fillMaxWidth()
        ){
            desserts.forEach { dessert ->
                DropdownMenuItem(
                    text = { Text(dessert) },
                    onClick = {
                        expanded = false
                        selectedText = dessert
                    }
                )
            }
        }
    }
}

@Composable // 16.74
fun MyDivider() {
    Text("Divider:")
    HorizontalDivider(Modifier
        .fillMaxWidth()
        .padding(top = 16.dp, bottom = 16.dp), color = Color.Green)
}

@Composable // 16.74
fun MyBadgeBox() {
    Text("BadgeBox:")
    BadgedBox(
        badge = {
            Badge(containerColor = Color.Red) {
                Text("16", color = Color.White)
            }
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription="")
    }
}

@Composable // 16.72
// A Card is a surface with a default elevation and shape
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            contentColor = Color.Green,
            containerColor = Color.DarkGray
        ),
        border = BorderStroke(5.dp, Color.Green)
    ) {
        Column(modifier = Modifier.padding(16.dp)){
            Text("Example 1")
            Text("Example 2")
            Text("Example 3")
        }
    }
}