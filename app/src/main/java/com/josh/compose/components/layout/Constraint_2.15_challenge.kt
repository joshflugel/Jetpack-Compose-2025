package com.josh.compose.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview(showBackground = true)
@Composable
fun constraint_2_15_challenge_preview() {
    constraint_2_15_challenge_wrapper()
}

@Composable
fun constraint_2_15_challenge_wrapper(){
    constraint_2_15_challenge(Modifier)
}

@Composable
fun constraint_2_15_challenge(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val(yellowBox, magentaBox, greenBox, grayBox, redBox,
            blueBox, cyanBox, blackBox, darkGrayBox,
            upperRow) = createRefs()
        Box(Modifier.size(75.dp).background(Color.Yellow).constrainAs(yellowBox){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        })

        Box(Modifier.size(175.dp).background(Color.Blue).constrainAs(blueBox){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(yellowBox.bottom)
        })

        Box(Modifier.size(75.dp).background(Color.Magenta).constrainAs(magentaBox){
            bottom.linkTo(yellowBox.top)
            end.linkTo(yellowBox.start)
        })

        Box(Modifier.size(75.dp).background(Color.Green).constrainAs(greenBox){
            start.linkTo(yellowBox.end)
            bottom.linkTo(yellowBox.top)
        })

        Box(Modifier.size(75.dp).background(Color.Gray).constrainAs(grayBox){
            top.linkTo(yellowBox.bottom)
            end.linkTo(yellowBox.start)
        })

        Box(Modifier.size(75.dp).background(Color.Red).constrainAs(redBox){
            start.linkTo(yellowBox.end)
            top.linkTo(yellowBox.bottom)
        })

        Box(Modifier.size(75.dp).background(Color.Black).constrainAs(ref = blackBox) {
            start.linkTo(parent.start)
            end.linkTo((parent.end))
            top.linkTo(cyanBox.top)
            bottom.linkTo(cyanBox.bottom)
        })

        Box(Modifier.size(175.dp).background(Color.Cyan).constrainAs(cyanBox) {
            end.linkTo(blackBox.start)
            bottom.linkTo(magentaBox.top)
        })
        Box(Modifier.size(175.dp).background(Color.DarkGray).constrainAs(darkGrayBox) {
            start.linkTo(blackBox.end)
            bottom.linkTo(greenBox.top)
        })
    }
}