package com.davidson.movieslist


var movieList = mutableListOf<Movie>()

val MOVIE_ID_EXTRA = "bookExtra"

class Movie (var cover: Int,
             var title: String,
             var year: String,) {
}

