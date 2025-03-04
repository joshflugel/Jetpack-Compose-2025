package com.josh.compose.model

sealed class Routes(val route: String) {
    object Pantalla1:Routes("pantalla1")
    object Pantalla2:Routes("pantalla2")
    object Pantalla3:Routes("pantalla3")

    //SLASH = Non optional, Required param:
    object Pantalla4:Routes("pantalla4/{age}"){
        fun createRoute(age: Int) = "pantalla4/$age"
    }

    // ? QUESTION MARK = optional param:
    object Pantalla5:Routes("pantalla5?{name}") {
        fun createRoute(name: String) = "pantalla5?$name"
    }
}