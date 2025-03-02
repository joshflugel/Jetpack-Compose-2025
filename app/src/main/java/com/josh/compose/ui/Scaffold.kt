package com.josh.compose.ui

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldExample() {
    /* snackbarHostState replaces scaffoldState, AI explanation:
    📅 Timeline of ScaffoldState:
    First introduced:
    ScaffoldState was introduced with Jetpack Compose 1.0.0 (July 28, 2021).
    Deprecated:
    ScaffoldState was replaced in Material 3 with SnackbarHostState and DrawerState in Compose Material 3 v1.1.0 (June 7, 2023).
    Total active duration:
    ~1 year and 10 months (from July 2021 to June 2023).
     */
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        // 22.100
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = { MyTopBar { coroutineScope.launch { snackbarHostState.showSnackbar("You tapped $it") } } },
        content = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(onClickIcon:(String) -> Unit) {
    TopAppBar(title = {Text("First Toolbar")},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
            scrolledContainerColor = Color.Red.copy(alpha = 0.9f) // Simulate elevation effect
        ),
        navigationIcon = {
            IconButton(onClick = {onClickIcon("Back")}) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")//, tint = Color.White) // Material3
            }
        },
        actions = {
            IconButton(onClick = {onClickIcon("Search")}) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = {onClickIcon("Dangerous")}) {
                Icon(imageVector = Icons.Filled.Dangerous, contentDescription = "dangerous")
            }
        }
    )
}