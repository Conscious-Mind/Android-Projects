package com.davidson.rockpaperscissor2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GameViewModel :ViewModel(){

    private val _playerScore = MutableLiveData(0)
    val playerScore: LiveData<Int>
        get() =_playerScore

    private val _compScore = MutableLiveData(0)
    val compScore: LiveData<Int>
        get() =_compScore

    private val _playerChoice = MutableLiveData<Int>(1)
    val playerChoice: LiveData<Int>
        get() = _playerChoice

    private val _compChoice = MutableLiveData<Int>(2)
    val compChoice: LiveData<Int>
        get() = _compChoice

    private val _playerState = MutableLiveData<String>("state_initial")
    val playerState: LiveData<String>
        get() = _playerState

    private val _playerResult = MutableLiveData<String>("START NOW")
    val playerResult: LiveData<String>
        get() = _playerResult



    fun beginGame(userChoice: Int) {
        setPlayerChoice(userChoice)
        setCompChoice()
        _playerChoice.value?.let { _compChoice.value?.let { it1 -> displayResult(it, it1) } }
    }


    private fun setCompChoice() {
        when (Random.nextInt(1, 4)) {
            1 -> _compChoice.value = 1
            2 -> _compChoice.value = 2
            else -> _compChoice.value = 3
        }
    }

    private fun setPlayerChoice(choice: Int) {
        when (choice) {
            1 -> _playerChoice.value = 1
            2 -> _playerChoice.value = 2
            else -> _playerChoice.value = 3
        }
    }

    private fun displayResult(playerChoice: Int, computerChoice: Int){
        if(computerChoice == playerChoice) {
            _playerState.value = "state_draw"
            _playerResult.value = "Match Draw!!!"
        }
        else if(playerChoice == 1 && computerChoice == 3) {
            _playerState.value = "state_win"
            _playerScore.value = _playerScore.value?.plus(1)
            _playerResult.value = "You Won!!!"
        } else if(playerChoice == 3 && computerChoice == 1) {
            _playerState.value = "state_lose"
            _compScore.value = _compScore.value?.plus(1)
            _playerResult.value = "Computer Won!!!"
        } else if(playerChoice < computerChoice) {
            _playerState.value = "state_lose"
            _compScore.value = _compScore.value?.plus(1)
            _playerResult.value = "Computer Won!!!"
        } else {
            _playerState.value = "state_win"
            _playerScore.value = _playerScore.value?.plus(1)
            _playerResult.value = "You Won!!!"
        }
    }

    fun whichDrawablePlayer(): Int {
        return when (playerChoice.value) {
            1 -> R.drawable.rock
            2 -> R.drawable.paper
            else -> R.drawable.scissor
        }
    }
    fun whichDrawableComp(): Int {
        return when (compChoice.value) {
            1 -> R.drawable.rock
            2 -> R.drawable.paper
            else -> R.drawable.scissor
        }
    }
    fun setPlayerState(): Int {
        return when (playerState.value) {
            "state_win" -> R.drawable.state_win
            "state_lose" -> R.drawable.state_lose
            else -> R.drawable.state_draw
        }
    }
}