package com.davidson.breakingbad.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.davidson.breakingbad.adapter.RvBreakingBadHomeAdapter
import com.davidson.breakingbad.databinding.FragmentHomeBinding
import com.davidson.breakingbad.viewmodels.HomeViewModel
import com.davidson.breakingbad.viewmodels.HomeViewModelFactory


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val homeViewModelFactory = HomeViewModelFactory(requireActivity().application)
        viewModel = ViewModelProvider(this, homeViewModelFactory)[HomeViewModel::class.java]

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        val rvAdapterHome = RvBreakingBadHomeAdapter().also {
            it.setOnclickListenerR { imageView, breakingBadCharacter ->
                Toast.makeText(
                    activity,
                    breakingBadCharacter.characterName + breakingBadCharacter.characterId,
                    Toast.LENGTH_SHORT
                ).show()
                val extras = FragmentNavigatorExtras(imageView to "ivCharacterDetail")
                findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToCharacterFragment(
                        breakingBadCharacter.characterId
                    ), extras
                )
            }
        }

        binding.rvHome.apply {
            adapter = rvAdapterHome
        }



        viewModel.breakingBadCharacterList.observe(viewLifecycleOwner) {
            binding.tvChecking.text = it.size.toString()
            rvAdapterHome.submitList(it)
        }

        return binding.root
    }

}