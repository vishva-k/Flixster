package com.example.flixster

import org.json.JSONArray
import org.json.JSONObject

fun parseMovieData(jsonResponse: String): List<Movie> {
    val movies = mutableListOf<Movie>()

    val jsonObject = JSONObject(jsonResponse)
    val resultsArray = jsonObject.getJSONArray("results")

    for (i in 0 until resultsArray.length()) {
        val movieObject = resultsArray.getJSONObject(i)
        val title = movieObject.getString("title")
        val overview = movieObject.getString("overview")
        val posterPath = movieObject.getString("poster_path")

        val movie = Movie(title, overview, posterPath)
        movies.add(movie)
    }

    return movies
}