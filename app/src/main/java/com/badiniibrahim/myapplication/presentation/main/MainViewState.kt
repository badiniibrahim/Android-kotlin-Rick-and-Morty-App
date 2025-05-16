package com.badiniibrahim.myapplication.presentation.main

import com.badiniibrahim.myapplication.domain.models.CharacterModel

data class MainViewState (
    val isLoading:Boolean = false,
    val mainData: List<CharacterModel> = emptyList(),
    val  errorMessage:String? = null
)