package com.josh.compose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.josh.compose.model.Routes

@Composable
fun ScreenCyan(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        Text(
            "Cyan Screen",
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Routes.Pantalla2.route)
                })
    }
}

@Composable
fun ScreenMagenta(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ) {
        Text(
            "Magenta Screen",
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Routes.Pantalla3.route)
                })
    }
}

@Composable
fun ScreenRed(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        Text(
            "Red Screen",
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    // navigationController.navigate("pantalla4/128") // basic way
                    navigationController.navigate((Routes.Pantalla4.createRoute(32)))
                })
    }
}

// Screen with Required Parameters (non optional)
@Composable
// fun ScreenGreen(navigationController: NavHostController, name:String) {
fun ScreenGreen(navigationController: NavHostController, age:Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            "Green Screen, Ich bin: ${age} Jahre alt",
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Routes.Pantalla5.createRoute("Bombadil"))
                })
    }
}

@Composable
fun ScreenFunf(navigationController: NavHostController, name: String?) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Yellow)) {
        Text(
            "Screen Funf. Name: $name",
            color = Color.Black,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navigationController.navigate(Routes.Pantalla1.route)
                })
    }
}