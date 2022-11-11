package com.davidson.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.davidson.movieslist.databinding.FragmentMovieBinding


class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        populateMovies()

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = MovieCardAdapter(movieList)
        }
    }

    private fun populateMovies() {
        val ironman1 = Movie(R.drawable.iron_man_1, "Iron Man", "2008")
        movieList.add(ironman1)

        val hulk = Movie(R.drawable.the_incredible_hulk, "The Incredible Hulk", "2008")
        movieList.add(hulk)

        val ironman2 = Movie(R.drawable.iron_man_2, "Iron Man 2", "2010")
        movieList.add(ironman2)

        val thor = Movie(R.drawable.thor_1, "Thor", "2011")
        movieList.add(thor)

        val america =
            Movie(R.drawable.captain_america_1, "Captain America: The First Avenger", "2011")
        movieList.add(america)

        val avenger1 = Movie(R.drawable.the_avengers_1, "The Avengers", "2012")
        movieList.add(avenger1)

        movieList.add(ironman1)
        movieList.add(hulk)
        movieList.add(ironman2)
        movieList.add(thor)
        movieList.add(america)
        movieList.add(avenger1)
    }

}