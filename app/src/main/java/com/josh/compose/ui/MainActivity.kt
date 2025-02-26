package com.josh.compose.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josh.compose.components.layout.CheckInfo
import com.josh.compose.components.layout.MyAlertDialog
import com.josh.compose.components.layout.MyBadgeBox
import com.josh.compose.components.layout.MyCard
import com.josh.compose.components.layout.MyCheckbox
import com.josh.compose.components.layout.MyCheckboxWithText
import com.josh.compose.components.layout.MyCheckboxWithTextAdvanced
import com.josh.compose.components.layout.MyCustomDialog
import com.josh.compose.components.layout.MyDivider
import com.josh.compose.components.layout.MyDropdownMenu
import com.josh.compose.components.layout.MyRadioButton
import com.josh.compose.components.layout.MyRadioButtonList
import com.josh.compose.components.layout.MyRangeSlider
import com.josh.compose.components.layout.MySimpleCustomDialog
import com.josh.compose.components.layout.MySliderAdvanced
import com.josh.compose.components.layout.MySliderBasic
import com.josh.compose.ui.theme.BasicComposeAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    var show by rememberSaveable { mutableStateOf(false) }
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("18) AlertDialog (Material3)")

                        Button(onClick = { show = true}) {
                            Text("Show Material3 AlertDialog")
                        }

                        MySimpleCustomDialog(
                            show = show,
                            onDismiss = { show = false}
                        )

                        MyCustomDialog(
                            show = show,
                            onDismiss = { show = false }
                        )
                        /*MyAlertDialog(
                            //show,
                            false,
                            onDismiss = {
                                show = false
                                Log.i("joshtag", "AlertDialog: CONFIRM")
                                        },
                            onConfirm = { Log.i("joshtag", "AlertDialog: CONFIRM") }) */
                    }

                    Column( modifier = Modifier.fillMaxSize()) {
                        MySpacer(45)




                        /*
                        Text("17) Slider Component")
                        MyRangeSlider()
                        MySliderAdvanced()
                        MySliderBasic()
                         */

                        /*
                        Text("16) Other Components")  // 16) Other Components
                        MyDropdownMenu()
                        MyBadgeBox()
                        MyDivider()
                        Text("Card:")
                        MyCard()
                         */

                        /*
                        Column() {
                            Text("15) Selection Control Components")

                            var selected by rememberSaveable { mutableStateOf("Beef") }
                            MyRadioButtonList(selected) { selected = it }

                            val ingredients = listOf("Bacon", "Cheese", "Pickles", "BBQ")
                            val checkboxListOfIngredients = getCheckboxListOfIngredients(ingredients)

                            MyRadioButton()
                            MyTriStatusCheckBox()
                            checkboxListOfIngredients.forEach { ingredient ->
                                MyCheckboxWithTextAdvanced(ingredient)
                            }
                            MyCheckboxWithText()
                            MyCheckbox()
                            MySwitch()
                        }
                         */

                        // 14.64 ProgressBarAdvanced
                        // MyProgressBarAdvanced()
                        // 14.63 ProgressBar  , circular/linear
                        // MyProgressBar()

                        /*
                        // 13.62
                        MyIcon()
                        // 13.60, 13.61
                        MyImage()
                        MyAdvancedImage()

                        // 12.57
                        MyButtonExample()
                         */

                        // 11.55 State Hoisting
                        // var myText by rememberSaveable { mutableStateOf("") }
                        // MyTextFieldStateHoisting(myText) { myText = it }

                        /*
                        MyTextFieldOutlined()   // 10.54
                        MyTextFieldAdvanced()   // 10.53
                        MyTextField_10_52()     // 10.52
                        // MyText(Modifier.padding(innerPadding)) // 10.51
                        // MyStateExample()  // 9.x                      
                         */

                        // MyComplexLayout() //8.38
                        // MyRow() //8.37
                        // MyColumn() 8.36
                        // MyBox("") //8.35
                        // MySuperText("hey2")  //7.34
                    }
                    // MyButtons(Modifier.padding(innerPadding)) //sec6
                    // MyTextFieldParent(Modifier.padding(innerPadding))
                    // MyState2_20(Modifier.padding(innerPadding))
                    // MyState2_19(Modifier.padding(innerPadding))
                    // ConstraintChain(Modifier.padding(innerPadding))                // ConstraintAdvancedGuide(Modifier.padding(innerPadding))
                    // ConstraintBarrier(Modifier.padding(innerPadding))              // ConstraintAdvancedGuide(Modifier.padding(innerPadding))
                    // exe_constraint_2_15(Modifier.padding(innerPadding))
                    // MyConstraintLayout(Modifier.padding(innerPadding))
                    // Exe_2_11(Modifier.padding(innerPadding))
                    // MyComplexLayout(Modifier.padding(innerPadding))
                    // MyRow(Modifier.padding(innerPadding))
                    // MyColumn(Modifier.padding(innerPadding))
                    // Greeting( name = "Android", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    BasicComposeAppTheme {
        MyComplexLayout()
    }
}



// 13.64
@Composable
fun MyProgressBarAdvanced() {
    var progress by rememberSaveable { mutableStateOf(0f) }
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("12) Progressbar Component")
        CircularProgressIndicator(
            modifier = Modifier.padding(24.dp),
            progress = { progress },
        )
        LinearProgressIndicator(
            modifier = Modifier.padding(24.dp),
            progress = { progress },
        )
        Row {
            Button(modifier = Modifier.padding(24.dp),
                onClick = {
                if (progress < 1) {progress += 0.1f}
            }) {
                Text("Increase")
            }
            Button(modifier = Modifier.padding(24.dp),
                onClick = {
                if (progress > 0) {progress -= 0.1f}
            }) {
                Text("Decrease")
            }
        }
    }
}

// 13.63
@Composable
fun MyProgressBar() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(Modifier
        .padding(24.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        if(showLoading) {
            CircularProgressIndicator(color = Green, strokeWidth = 6.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(24.dp),
                color = Green,
                trackColor = DarkGray
            )
        }
        Button( onClick = {showLoading = !showLoading}) {
            Text("Load Profile")
        }
    }
}

// 13.62
@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Star, //.BunchOfIcons
        contentDescription = "Icono",
        tint = Red
    )
}

// 8.48
@Composable
fun MyStateExample() {
    // var counter = 0 PITALL, won't work because of recomposition. Instead, use
    // val counter = remember { mutableStateOf(0) }                 // Does not persist Rotation
    // val counter = rememberSaveable() { mutableStateOf(0) }       // Persists rotation, lifecycle safe
    var counter by rememberSaveable() { mutableStateOf(0) }    // Use By, to skip calling .value all around
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {      // .value no longer necessary, because of By
            Text("Press")
        }
        Text("Pressed ${counter} times.")    // .value no longer necessary, because of By
    }
}

// 8.41
@Composable
fun MySpacer(height: Int) {
    Spacer(modifier = Modifier.height(height.dp))
}

// 8.38
@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()){
        Box(Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Cyan),
            contentAlignment = Alignment.Center) {
            Text("Hello 1")
        }
        Row(Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red),
                contentAlignment = Alignment.Center) {
                Text("Hello 2")
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text("Hi I am Jon Foo")
            }
        }
        Box(Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter) {
            Text("Hello Bottom")
        }


    }
}

// 8.37
@Composable
fun MyRow() {
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text("Row example 1", modifier = Modifier.width(100.dp))
        Text("Row example 1", modifier = Modifier.width(100.dp))
        Text("Row example 1", modifier = Modifier.width(100.dp))
        Text("Row example 1", modifier = Modifier.width(100.dp))
        Text("Row example 1", modifier = Modifier.width(100.dp))
        Text("Row example 1", modifier = Modifier.width(100.dp))
        Text("Row example 1", modifier = Modifier.width(100.dp))
    }
}

// 8.36
@Composable
fun MyColumn() {
    Column(Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center) {
        // WEIGHT
        // Text("Example 1", modifier = Modifier.background(Color.Red).fillMaxWidth().weight(1f))
        Text("Example 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 2", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 2", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 2", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 2", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 2", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 2", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text("Example 2", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(100.dp))
    }
}



// 8.35 Box
@Composable
fun MyBox(string: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd) {
        Box(modifier = Modifier
            .width(30.dp)
            .height(30.dp)
            .background(Color.Cyan)
            .verticalScroll(
                rememberScrollState()
            )){
            Text("SOME TEXT")
        }
    }
}

// 7.33 Previews
/*
@Preview(
    name = "Preview 1",
    heightDp = 50,
    widthDp = 200,
    showBackground = true,
    apiLevel = 29,
    device = Devices.NEXUS_5)

 */
@Composable
fun MySuperText_wrapper() {
    MySuperText("hey")
}

@Composable
fun MySuperText(name: String){
    Text(text = "I am Josh :), $name",
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun GreetingPreview() {
    BasicComposeAppTheme {
        Greeting("Androidsss")
    }
}

@Composable
fun Example(a: String) {
    Text(text = "Aris $a", modifier = Modifier.height(33.dp))
}