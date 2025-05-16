package com.badiniibrahim.myapplication.data.dataSource.remote

import com.badiniibrahim.myapplication.domain.models.CharacterModel
import com.badiniibrahim.myapplication.domain.models.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApi {
    @GET("character")
    suspend fun getCharacter(): CharactersResponse


    @GET("character/{id}")
    suspend fun getCharacterById(
        @Path("id") id: Int
    ): CharacterModel
}