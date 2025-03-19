package com.josh.compose.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
    // ✅ Use rememberCoroutineScope() for launching coroutines in response to
    // // user actions (e.g., button clicks, drawer interactions) inside a Composable:
    val coroutineScope = rememberCoroutineScope()
    var drawerState = rememberDrawerState(DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MyDrawer({coroutineScope.launch { drawerState.close() }})
        },
        gesturesEnabled = false
    ) {
        Scaffold(
            // 22.100
            snackbarHost = { SnackbarHost(snackbarHostState) },
            topBar = {
                MyTopBar (
                    onClickIcon = { coroutineScope.launch { snackbarHostState.showSnackbar("You tapped $it") } },
                    onClickDrawer = {
                        coroutineScope.launch { drawerState.open() }
                    })
            },
            content = {},
            bottomBar = { MyBottomNavigation() },
            floatingActionButton = { MyFAB() },
            floatingActionButtonPosition = FabPosition.Center
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(onClickIcon:(String) -> Unit, onClickDrawer:() -> Unit) {
    TopAppBar(title = {Text("First Toolbar")},
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Red,
            titleContentColor = Color.White,
            scrolledContainerColor = Color.Red.copy(alpha = 0.9f) // Simulate elevation effect
        ),
        navigationIcon = {
            IconButton(
                onClick = {
                    onClickIcon("Menu")
                    onClickDrawer()
                }) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Menu")
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


@Composable
fun MyBottomNavigation() {
    var index by remember { mutableStateOf(0) }
    NavigationBar (
        containerColor = Color.Gray
    ) {
        NavigationBarItem(
            selected = index == 0,
            onClick = { index = 0 },
            icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home")}
        )
        NavigationBarItem(
            selected = index == 1,
            onClick = { index = 1 },
            icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Fav") },
            label = { Text("Favorites") }
        )
        NavigationBarItem(
            selected = index == 2,
            onClick = { index = 2},
            icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "Person") },
            label = { Text("Person") }
        )
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(onClick = {}, contentColor = Color.Black, containerColor = Color.Yellow) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
    }
   SmallFloatingActionButton(onClick = {}, contentColor = Color.Black, containerColor = Color.Yellow) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add Small Button")
    }
    LargeFloatingActionButton(onClick = {}, contentColor = Color.Black, containerColor = Color.Yellow) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "add Large Button")
    }
    ExtendedFloatingActionButton(onClick = { print("ExtendedFAB" )},
        contentColor = Color.Black,
        containerColor = Color.Yellow,
        text = { Text("Extended FAB")},
        icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "add Extended FAB Button") })

}

@Composable
fun MyDrawer(onClose:() -> Unit) {
    Box(Modifier
        .fillMaxHeight()
        .wrapContentWidth()
        .background(Color.DarkGray)) {
        Column(Modifier.padding(8.dp)) {
            Text(
                "Guitar Bass", modifier = Modifier
                    .wrapContentWidth()
                    .padding(8.dp)
                    .clickable { onClose() }
            )
            Text(
                "Electric Bass", modifier = Modifier
                    .wrapContentWidth()
                    .padding(8.dp)
                    .clickable { onClose() }
            )
            Text(
                "Baritone Guitar", modifier = Modifier
                    .wrapContentWidth()
                    .padding(8.dp)
                    .clickable { onClose() }
            )
        }
    }
}