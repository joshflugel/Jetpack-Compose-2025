package com.josh.compose.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp


@Composable
fun MyTexts(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "Pepe")
        Text(text = "Pepe rojo", color = Color.Red)
        Text(text = "Pepe", fontSize = 25.sp)
        Text("FontSyle", fontStyle = FontStyle.Italic)
        Text(
            "FontWeight",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 25.sp
        )
        Text("Letter Spacing", letterSpacing = 5.sp)
        Text("TextDecoretion", textDecoration = TextDecoration.Underline)
        Text("TextDecoretion", textDecoration = TextDecoration.Underline + TextDecoration.LineThrough)

        Text("URL",
            textDecoration = TextDecoration.Underline, color = Color.Blue,
            modifier = Modifier.clickable {  })
        Text("Align",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
        Text(
            "Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla  pepepepe",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }


}