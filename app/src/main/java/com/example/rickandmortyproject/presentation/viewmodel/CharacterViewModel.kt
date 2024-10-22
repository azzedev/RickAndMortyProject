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
}