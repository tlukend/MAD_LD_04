package com.example.movieappmad23.screens

sealed class Screen (val route: String) {
    object MainScreen : Screen("main_screen")
    object DetailScreen : Screen("detail_screen")
    object FavoriteScreen : Screen("favorite_screen")

}