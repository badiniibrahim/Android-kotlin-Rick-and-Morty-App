package com.badiniibrahim.myapplication.domain.repository

import arrow.core.Either
import com.badiniibrahim.myapplication.domain.models.CharacterModel
import com.badiniibrahim.myapplication.domain.models.CharactersResponse
import com.badiniibrahim.myapplication.domain.models.NetworkError

interface RickAndMortyRepository {
    suspend fun getCharacter():Either<NetworkError, CharactersResponse>
    suspend fun getCharacterById(id:Int):Either<NetworkError, CharacterModel>
}