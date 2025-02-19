package com.josh.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josh.compose.components.layout.MyTexts
import com.josh.compose.ui.theme.BasicComposeAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyTexts(Modifier.padding(innerPadding))
                //) MyState2_20(Modifier.padding(innerPadding))
                    //MyState2_19(Modifier.padding(innerPadding))
                    //ConstraintChain(Modifier.padding(innerPadding))                //ConstraintAdvancedGuide(Modifier.padding(innerPadding))
                    //ConstraintBarrier(Modifier.padding(innerPadding))                //ConstraintAdvancedGuide(Modifier.padding(innerPadding))
                    //exe_constraint_2_15(Modifier.padding(innerPadding))
                    // MyConstraintLayout(Modifier.padding(innerPadding))
                    // Exe_2_11(Modifier.padding(innerPadding))
                    //MyComplexLayout(Modifier.padding(innerPadding))
                    //MyRow(Modifier.padding(innerPadding))
                    //MyColumn(Modifier.padding(innerPadding))
                    //Greeting( name = "Android", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    widthDp = 50,
    heightDp = 30,
    showSystemUi = true,
    device = Devices.PIXEL_4
)
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