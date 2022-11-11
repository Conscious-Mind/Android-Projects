package com.davidson.breakingbad.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.davidson.breakingbad.database.getDatabase
import com.davidson.breakingbad.repository.BreakingBadRepository
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val breakingBadRepo = BreakingBadRepository(getDatabase(application))

    val breakingBadCharacterList = breakingBadRepo.characters

    init {
        viewModelScope.launch {
            breakingBadRepo.getCharactersFromNetwork()
        }
    }
}