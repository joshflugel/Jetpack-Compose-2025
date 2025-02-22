package com.josh.compose.ui

import android.annotation.SuppressLint
import android.os.Bundle
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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josh.compose.components.layout.MyButtonExample
import com.josh.compose.components.layout.MyOutlinedTextField
import com.josh.compose.components.layout.MyText
import com.josh.compose.components.layout.MyTextFieldAdvanced
import com.josh.compose.components.layout.MyTextFieldOutlined
import com.josh.compose.components.layout.MyTextFieldStateHoisting
import com.josh.compose.components.layout.MyTextField_10_52
import com.josh.compose.ui.theme.BasicComposeAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column( modifier = Modifier.fillMaxSize()) {
                        MySpacer(30)

                        // 12.57
                        MyButtonExample()

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