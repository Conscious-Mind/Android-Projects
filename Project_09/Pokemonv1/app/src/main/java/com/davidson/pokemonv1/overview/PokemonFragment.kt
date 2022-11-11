package com.davidson.pokemonv1.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.davidson.pokemonv1.R
import com.davidson.pokemonv1.databinding.FragmentPokemonBinding


class PokemonFragment : Fragment() {
    private lateinit var binding: FragmentPokemonBinding

    private val viewModel: PokemonViewModel by lazy {
        ViewModelProvider(this).get(PokemonViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPokemonBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel


        return binding.root
    }

}