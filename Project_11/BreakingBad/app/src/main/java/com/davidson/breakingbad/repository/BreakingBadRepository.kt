package com.davidson.breakingbad.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.davidson.breakingbad.database.BreakingBadDatabase
import com.davidson.breakingbad.database.DatabaseBreakingBad
import com.davidson.breakingbad.database.asDomainModel
import com.davidson.breakingbad.domain.BreakingBadCharacter
import com.davidson.breakingbad.network.BBNetwork
import com.davidson.breakingbad.network.asDatabaseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BreakingBadRepository(private val database: BreakingBadDatabase) {

    private val _characters = MutableLiveData<List<DatabaseBreakingBad>>()
    val characters: LiveData<List<BreakingBadCharacter>>
        get() = Transformations.map(_characters) {
            it.asDomainModel()
        }


    init {
        refreshCharacterListInRepo()

    }

    private fun refreshCharacterListInRepo() {
        CoroutineScope(Dispatchers.IO).launch {
            _characters.postValue(database.BreakingBadDao.getAllCharacterFromDb())
        }
    }


    suspend fun getCharactersFromNetwork() {
        withContext(Dispatchers.IO) {
            try {
                val breakingBadCharactersFromNetwork =
                    BBNetwork.retrofitBreakingBadService.getAllCharactersFromNetwork()

                database.BreakingBadDao.deleteAll()

                database.BreakingBadDao.insertAll(breakingBadCharactersFromNetwork.asDatabaseModel())

                refreshCharacterListInRepo()

            } catch (e: Exception) {
                Log.e("ERROR_REPO", (e.message.toString() ?: "ERROR IN REPO"))
            }
        }
    }

    suspend fun getCharacterDetailsFromDb(characterId: Int): BreakingBadCharacter {
        return withContext(Dispatchers.IO) {
            database.BreakingBadDao.getCharacterFromDb(characterId).asDomainModel()
        }
    }
}