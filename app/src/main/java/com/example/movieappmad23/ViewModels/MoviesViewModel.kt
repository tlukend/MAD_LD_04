package com.example.movieappmad23.ViewModels

import android.util.Log
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.example.movieappmad23.models.Movie
import com.example.movieappmad23.models.getMovies
import com.example.movieappmad23.models.Genre
import com.example.movieappmad23.models.ListItemSelectable

class MoviesViewModel: ViewModel() {

    private val _moviesList = getMovies().toMutableStateList()
    val movieList: List<Movie>
        get() = _moviesList

    fun filterMovie (movieId : String): Movie {
        return _moviesList.filter { it.id == movieId }[0]
    }
    fun getFavorites (): List<Movie> {
        return _moviesList.filter {it.isFavorite}
    }

    fun remove(movie: Movie){
        _moviesList.remove(movie)
    }
    fun toggleToFavorite(movie:Movie){
        val movieFound = _moviesList.find {it.id == movie.id}
        if (movieFound != null){
            movieFound.isFavorite = !movieFound.isFavorite
        }
        Log.i("toggle happens", movie.title + "isFavorite: ${movie.isFavorite}")
    }


    fun addMovie (movie: Movie){
        _moviesList.add(movie)
    }

    // validations:


    fun checkIfEmptyString (input: String) : Boolean {
        return input.isNotEmpty()
    }
    fun checkIfString (input: Any): Boolean {
        return input is String
    }

// this part is done with the help of Giuliana Imperiale

    fun selectedGenres (genreList: List<ListItemSelectable>): MutableList<Genre>{
        val selectedGenresList: MutableList<Genre> = mutableListOf()
        for (genre in genreList) {
            if (genre.isSelected) {
                selectedGenresList.add(enumValueOf(genre.title))
            }
        }
        return selectedGenresList
    }

//i got stuck at my approach
/*
    fun checkIfGenre (selectedList: MutableList<ListItemSelectable>){
        val enumList: MutableList<Genre> = mutableListOf<Genre>().toString()
        for (item in selectedList){
            if(item.title.contains(enumList) )
        }
    }
*/

    fun checkIfAtLeastOneGenre (genreList: MutableList<ListItemSelectable>) : Boolean {
        for (item in genreList){
            if(item.isSelected) {   //if isSelected is true, after first found "true", its considered checked
            }
        }
        return true
    }
    fun checkRating (input: String) : Boolean {
        return input.toFloatOrNull() != null && input.toFloat() in 0.0..10.0
    }
    

}