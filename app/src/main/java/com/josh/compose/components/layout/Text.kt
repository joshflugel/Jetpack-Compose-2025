package com.josh.compose.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp


@Composable
fun MyText(modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = "Josh")
        Text(text = "Josh Red", color = Color.Red)
        Text(text = "Josh 25.sp", fontSize = 25.sp)
        Text("Josh FontStyle.Italic", fontStyle = FontStyle.Italic)
        Text(
            "FontWeight.ExtraBold, FontStyle.Italic, fontSize=25.sp",
            fontWeight = FontWeight.ExtraBold,
            fontStyle = FontStyle.Italic,
            fontSize = 25.sp
        )
        Text("letterSpacing", letterSpacing = 5.sp)
        Text("FontFamily.Cursive", fontFamily = FontFamily.Cursive)
        Text("TextDecoration.Underline", textDecoration = TextDecoration.Underline)
        Text("TextDecoration.Underline + .LineThrough ", textDecoration = TextDecoration.Underline + TextDecoration.LineThrough)

        Text("URL = TextDeco.Underline + Color.Blue",
            textDecoration = TextDecoration.Underline, color = Color.Blue,
            modifier = Modifier.clickable {  })
        Text("textAlign= .Center",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
        Text(
            "TextAlign.Center, maxLines=1, TextOverflow.Ellipsis, m=Modifier.background(Color.Red), Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla Bla  pepepepe",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}