package com.badiniibrahim.myapplication.domain.models

data class CharactersResponse(
    val info: Info,
    val results: List<CharacterModel>
)

data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: LocationInfo,
    val location: LocationInfo,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String
)

data class LocationInfo(
    val name: String,
    val url: String
)
