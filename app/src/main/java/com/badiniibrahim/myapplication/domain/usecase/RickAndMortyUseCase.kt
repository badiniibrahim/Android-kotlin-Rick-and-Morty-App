package com.badiniibrahim.myapplication.domain.usecase

import arrow.core.Either
import com.badiniibrahim.myapplication.domain.models.CharacterModel
import com.badiniibrahim.myapplication.domain.models.CharactersResponse
import com.badiniibrahim.myapplication.domain.models.NetworkError
import com.badiniibrahim.myapplication.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyUseCase @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) {
    suspend operator fun invoke():Either<NetworkError,CharactersResponse>{
        return rickAndMortyRepository.getCharacter()
    }

    suspend  fun invokeById(id:Int):Either<NetworkError,CharacterModel>{
        return rickAndMortyRepository.getCharacterById(id)
    }
}