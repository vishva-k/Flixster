package com.example.flixster

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvOverview: TextView = itemView.findViewById(R.id.tvOverview)
        val ivMoviePoster: ImageView = itemView.findViewById(R.id.ivMoviePoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        Log.d("MovieAdapter", "Creating MovieViewHolder")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.tvTitle.text = movie.title
        holder.tvOverview.text = movie.overview
        val imageUrl = "https://image.tmdb.org/t/p/w500/${movie.posterPath}"
        Log.d("MovieAdapter", "Binding movie: $movie to MovieViewHolder")
        Glide.with(holder.ivMoviePoster.context)
            .load(imageUrl)
            .into(holder.ivMoviePoster)
    }

    override fun getItemCount(): Int {
        val itemCount = movies.size
        Log.d("MovieAdapter", "Item count: $itemCount")
        return itemCount
    }
}