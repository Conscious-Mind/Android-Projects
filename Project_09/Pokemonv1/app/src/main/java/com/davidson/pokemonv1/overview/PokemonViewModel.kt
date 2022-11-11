package com.davidson.pokemonv1.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.davidson.pokemonv1.network.PokemonApi
import com.davidson.pokemonv1.network.PokemonContainer
import com.davidson.pokemonv1.network.PokemonProperty
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


enum class PokemonApiStatus {LOADING, ERROR, DONE}

class PokemonViewModel: ViewModel() {

    private val _status = MutableLiveData<PokemonApiStatus>()
    val status: LiveData<PokemonApiStatus>
        get() = _status

    private val _container = MutableLiveData<List<PokemonProperty>>()
    val container: LiveData<List<PokemonProperty>>
        get() = _container

    val containerString:LiveData<String> = Transformations.map(container){it.toString()}

    init {
        getPokemonContainer()
    }

    private fun getPokemonContainer(){

        viewModelScope.launch {
            var getPokemonContainerDeferred = PokemonApi.retrofitService.getPokemons()
            try {
                _status.value = PokemonApiStatus.LOADING
                var result = getPokemonContainerDeferred.await()
                _status.value = PokemonApiStatus.DONE
                if (result != null) {
                    _container.value = result.pokemon
                }

            } catch (e: Exception) {
                _status.value = PokemonApiStatus.ERROR
                _container.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}

