package com.example.rickandmortyproject.data.api
import com.example.rickandmortyproject.data.model.Character
import com.example.rickandmortyproject.data.model.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") characterId: Int
    ): Character

    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int = 1
    ): CharacterResponse
}