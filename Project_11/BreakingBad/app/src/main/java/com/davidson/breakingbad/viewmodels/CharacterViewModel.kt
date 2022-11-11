package com.davidson.breakingbad.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.davidson.breakingbad.database.getDatabase
import com.davidson.breakingbad.domain.BreakingBadCharacter
import com.davidson.breakingbad.repository.BreakingBadRepository
import kotlinx.coroutines.launch

class CharacterViewModel(characterId: Int, application: Application) :
    AndroidViewModel(application) {

    private val breakingBadRepo = BreakingBadRepository(getDatabase(application))

    var characterDetails = MutableLiveData<BreakingBadCharacter>()


    init {
        viewModelScope.launch {
            getStrangerPersonById(characterId)
        }
    }

    private suspend fun getStrangerPersonById(characterId: Int) {
        val character = breakingBadRepo.getCharacterDetailsFromDb(characterId)
        characterDetails.postValue(character)
    }
}