package com.example.rickandmortyproject.data.repository
import com.example.rickandmortyproject.data.api.RetrofitInstance
import com.example.rickandmortyproject.data.model.Character
import com.example.rickandmortyproject.data.model.CharacterResponse

class CharacterRepository {
    suspend fun getCharacterById(characterId: Int): Character {
        return RetrofitInstance.api.getCharacterById(characterId)
    }

    suspend fun getAllCharacters(page: Int): CharacterResponse {
        return RetrofitInstance.api.getAllCharacters(page)
    }
}