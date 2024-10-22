package com.example.rickandmortyproject.data.repository
import com.example.rickandmortyproject.data.api.RetrofitInstance
import com.example.rickandmortyproject.data.model.Character

class CharacterRepository {
    suspend fun getCharacterById(characterId: Int): Character {
        return RetrofitInstance.api.getCharacterById(characterId)
    }
}