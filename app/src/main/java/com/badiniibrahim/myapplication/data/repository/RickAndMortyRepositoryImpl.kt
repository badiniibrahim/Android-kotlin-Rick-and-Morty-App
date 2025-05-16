package com.badiniibrahim.myapplication.data.repository

import arrow.core.Either
import com.badiniibrahim.myapplication.data.dataSource.remote.RickAndMortyApi
import com.badiniibrahim.myapplication.domain.models.CharacterModel
import com.badiniibrahim.myapplication.domain.models.CharactersResponse
import com.badiniibrahim.myapplication.domain.models.NetworkError
import com.badiniibrahim.myapplication.domain.repository.RickAndMortyRepository
import com.example.memes.data.mapper.toGeneralError
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
):RickAndMortyRepository {

    override suspend fun getCharacter(): Either<NetworkError, CharactersResponse> {
        return Either.catch {
            rickAndMortyApi.getCharacter()
        }.mapLeft {
            it.toGeneralError()
        }
    }

    override suspend fun getCharacterById(id: Int): Either<NetworkError, CharacterModel> {
        return Either.catch {
            rickAndMortyApi.getCharacterById(id)
        }.mapLeft {
            it.toGeneralError()
        }
    }
}