package com.davidson.breakingbad.ui


import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.davidson.breakingbad.adapter.bindImage
import com.davidson.breakingbad.databinding.FragmentCharacterBinding
import com.davidson.breakingbad.viewmodels.CharacterViewModel
import com.davidson.breakingbad.viewmodels.CharacterViewModelFactory


class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private lateinit var viewModel: CharacterViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharacterBinding.inflate(inflater, container, false)

        val animationDetailedImage = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        ).also {
            it.duration = 500L
        }

        sharedElementEnterTransition = animationDetailedImage


        val args: CharacterFragmentArgs by navArgs()

        val characterViewModelFactory = CharacterViewModelFactory(args.characterId, requireActivity().application)

        viewModel = ViewModelProvider(this, characterViewModelFactory)[CharacterViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.characterDetails.observe(viewLifecycleOwner){
            bindImage(binding.ivDetailedImage, it.characterImage)
        }




        return binding.root
    }

}