package com.davidson.movieslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.davidson.movieslist.databinding.MovieCardBinding

class MovieCardAdapter (
    private val movies: List<Movie>
) : RecyclerView.Adapter<CardViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val from = LayoutInflater.from(parent.context)
        val binding = MovieCardBinding.inflate(from, parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }

    override fun getItemCount(): Int = movies.size

}



class CardViewHolder(
    private val movieCardBinding: MovieCardBinding,
//    private val clickListener: BookClickListener
) : RecyclerView.ViewHolder(movieCardBinding.root)
{
    fun bindMovie(movie: Movie)
    {
        movieCardBinding.cover.setImageResource(movie.cover)
        movieCardBinding.title.text = movie.title
        movieCardBinding.year.text = movie.year

//        m.cardView.setOnClickListener{
//            clickListener.onClick(movie)
//        }
    }
}