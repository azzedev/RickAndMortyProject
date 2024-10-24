package com.example.rickandmortyproject.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyproject.data.model.Character
import com.example.rickandmortyproject.data.repository.CharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel (
    private val repository: CharacterRepository = CharacterRepository()
    ) : ViewModel() {

    private val _character = MutableStateFlow<Character?>(null)
    val character: StateFlow<Character?> = _character

    private val _charactersList = MutableStateFlow<List<Character>>(emptyList())
    val charactersList: StateFlow<List<Character>> = _charactersList

    private var currentPage = 1
    private var totalPages = 1
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessageCharacterList = MutableStateFlow<String?>(null)
    val errorMessageCharacterList: StateFlow<String?> = _errorMessageCharacterList

    fun fetchCharacterById(id: Int) {
        viewModelScope.launch {
            try {
                val character = repository.getCharacterById(id)
                println("Personnage récupéré : ${character.name}, Status: ${character.status}")
                _character.value = character
            } catch (e: Exception) {
                println("Erreur lors de la récupération du personnage : ${e.message}")
            }
        }
    }
    fun fetchAllCharacters(page: Int = 1) {
        if (_isLoading.value || page > totalPages) return

        _isLoading.value = true
        _errorMessageCharacterList.value = null
        viewModelScope.launch {
            try {
                val response = repository.getAllCharacters(page)
                totalPages = response.info.pages
                currentPage = page

                _charactersList.value = _charactersList.value + response.results
                println("Nombre de personnages récupérés : ${response.results.size} à la page $page")
            } catch (e: Exception) {
                println("Erreur lors de la récupération des personnages : ${e.message}")
                _errorMessageCharacterList.value = "GABIDULE n'a pas voulu vous donner ce que vous vouliez"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun loadNextPage() {
        if (currentPage < totalPages && !_isLoading.value) {
            fetchAllCharacters(currentPage + 1)
        }
    }
}
