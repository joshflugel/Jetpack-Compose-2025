package com.josh.compose.components.layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.josh.compose.R

@Composable
fun MyImage() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "Example",
        alpha = 0.5f
    )
}

@Composable
fun MyAdvancedImage() {
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "example",
        alpha = 0.5f,
        modifier = Modifier
        // .clip(RoundedCornerShape(25f))
            .clip(CircleShape)
            .border(5.dp, Color.Red, CircleShape)

    )
}