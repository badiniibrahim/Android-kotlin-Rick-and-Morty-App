package com.badiniibrahim.myapplication.presentation.navigation

sealed class Screen(val route: String) {
    data object Main : Screen("main")
    data object Detail : Screen("detail/{character}") {
        fun createRoute(character: Int): String {
            return "detail/$character"
        }
    }

}
