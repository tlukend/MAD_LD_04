package com.example.movieappmad23.ViewModels

import android.util.Log
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.models.getMovies

class MovieViewModel : ViewModel() {

    private val _movies = getMovies().toMutableStateList()
    val movies: List<Movie>
        get() = _movies



    fun remove(item: Movie){
        _movies.remove(item)
    }

    fun toggleToFavorite(movie: Movie) {
        //movies.find { it.id == movie.id }?.let { movie ->
        //    movie.isFavorite = !movie.isFavorite
        //}
        val movieFound = _movies.find { it.id == movie.id }
        if (movieFound != null) {
            movieFound.isFavorite = !movieFound.isFavorite
        }
        Log.i("toggle works", movie.title + " isFavorite? ->  ${movie.isFavorite}")
    }

}