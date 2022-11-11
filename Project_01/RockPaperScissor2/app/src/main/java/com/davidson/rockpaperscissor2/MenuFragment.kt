package com.davidson.rockpaperscissor2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.davidson.rockpaperscissor2.databinding.FragmentMenuBinding
import java.lang.System.exit


class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_menu, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.startGameButton.setOnClickListener {startGame()}
        binding.exitButton.setOnClickListener { exitGame() }
    }


    private fun startGame() {
        findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
    }

    private fun exitGame() {
        activity?.finish()
    }

}