package com.badiniibrahim.myapplication.presentation.detail

import com.badiniibrahim.myapplication.domain.models.CharacterModel

data class DetailViewState (
    val isLoading:Boolean = false,
    val mainData: CharacterModel? = null,
    val  errorMessage:String? = null
)