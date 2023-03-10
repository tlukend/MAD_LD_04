package com.example.movieappmad23.screens

sealed class Screen (val route: String) {
    object MainScreen : Screen("main")
    object DetailScreen : Screen("detail")
    object FavoriteScreen : Screen("favorite")

}