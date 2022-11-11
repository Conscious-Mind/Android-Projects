package com.davidson.rockpaperscissor2

import android.app.Fragment
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.davidson.rockpaperscissor2.databinding.FragmentGameBinding
import kotlin.random.Random


class GameFragment : Fragment() {

    private val viewModel: GameViewModel by viewModels()

    private lateinit var binding: FragmentGameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
//        viewModel = ViewModelProvider(this)[GameViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gameViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.rockButton.setOnClickListener{
            viewModel.beginGame(1)
            setImages()
        }
        binding.paperButton.setOnClickListener{
            viewModel.beginGame(2)
            setImages()
        }
        binding.scissorButton.setOnClickListener{
            viewModel.beginGame(3)
            setImages()
        }
    }

    private fun setImages() {
        binding.compChoiceImage.setImageResource(viewModel.whichDrawableComp())
        binding.playerChoiceImage.setImageResource(viewModel.whichDrawablePlayer())
        binding.resultImage.setImageResource(viewModel.setPlayerState())
    }

//    private fun getImageId(choice:Int):Int{
//        return when(choice){
//            1->R.drawable.rock
//            2 -> R.drawable.paper
//            else -> R.drawable.scissor
//        }
//    }
//
//
//    fun gameBegin(view: Int){
//        val playerChoice:Int = when(view){
//            binding.rockButton->1
//            binding.paperButton->2
//            else->3
//        }
//        binding.playerChoiceImage.setImageBitmap(BitmapFactory.decodeResource(resources,getImageId(playerChoice)))
//
//        val computerChoice = getCompChoice()
//        binding.compChoiceImage.setImageBitmap(BitmapFactory.decodeResource(resources,getImageId(computerChoice)))
//
//
//        val result :String = displayResult(playerChoice,computerChoice)
//        binding.resultTextView.text = result
//        binding.playerScoreTextView.text = playerScore.toString()
//        binding.compScoreTextView.text = computerScore.toString()
//
//
//    }
//
//    private fun displayResult(playerChoice:Int, computerChoice:Int):String{
//        return if(computerChoice == playerChoice) {
//            binding.resultImage.setImageResource(R.drawable.state_draw)
//            "Match Draw!!!"
//        }
//        else if(playerChoice == 1 && computerChoice == 3) {
//            binding.resultImage.setImageResource(R.drawable.state_win)
//            playerScore++
//            "You Won!!!"
//        } else if(playerChoice == 3 && computerChoice == 1) {
//            binding.resultImage.setImageResource(R.drawable.state_lose)
//            computerScore++
//            "Computer Won!!!"
//        } else if(playerChoice < computerChoice) {
//            binding.resultImage.setImageResource(R.drawable.state_lose)
//            computerScore++
//            "Computer Won!!!"
//        } else {
//            binding.resultImage.setImageResource(R.drawable.state_win)
//            playerScore++
//            "You Won!!!"
//        }
//    }
//
//    private fun getCompChoice():Int{
//        return Random.nextInt(1 , 4)
//    }

}