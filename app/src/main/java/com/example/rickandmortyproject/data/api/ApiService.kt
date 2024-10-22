package com.example.rickandmortyproject.data.api
import com.example.rickandmortyproject.data.model.Character
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {
    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") characterId: Int
    ): Character
}