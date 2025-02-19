package com.josh.compose.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun ConstraintBarrier_preview() {
    ConstraintBarrier_wrapper()
}

@Composable
fun ConstraintBarrier_wrapper() {
    ConstraintBarrier(Modifier.padding((16.dp)))
}

@Composable
fun ConstraintAdvancedGuide(modifier: Modifier) {

    ConstraintLayout(Modifier.fillMaxSize()) {
        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)

        Box(
            Modifier.size(150.dp)
                .background(Color.Red)
                .constrainAs(boxRed){
                    top.linkTo(topGuide)
                })
    }
}

@Composable
fun ConstraintBarrier(modifier: Modifier){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()
        // boxes in the Barrier:
        val barrier = createEndBarrier(boxRed, boxYellow)

        Box(Modifier.size(65.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        })
        Box(Modifier.size(200.dp).background(Color.Yellow).constrainAs(boxYellow){
            top.linkTo(boxRed.bottom, 40.dp)
            start.linkTo(parent.start, 32.dp)
        })

        Box(Modifier.size(70.dp).background(Color.Cyan).constrainAs(boxCyan){
            start.linkTo(barrier)
        })
    }
}

@Composable
fun ConstraintChain(modifier: Modifier){
    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxCyan) = createRefs()


        Box(Modifier.size(100.dp).background(Color.Red).constrainAs(boxRed){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(boxYellow.top)
        })
        Box(Modifier.size(100.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxRed.bottom)
            bottom.linkTo(boxCyan.top)
        })

        Box(Modifier.size(100.dp).background(Color.Cyan).constrainAs(boxCyan){
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(boxYellow.bottom)
            bottom.linkTo(parent.bottom)
        })
        createVerticalChain(boxRed, boxYellow, boxCyan, chainStyle = ChainStyle.Packed)
    }
}