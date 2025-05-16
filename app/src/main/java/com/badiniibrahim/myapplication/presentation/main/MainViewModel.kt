package com.badiniibrahim.myapplication.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.badiniibrahim.myapplication.domain.usecase.RickAndMortyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val rickAndMortyUseCase: RickAndMortyUseCase
):ViewModel() {
    private val _state = MutableStateFlow(MainViewState())
    val state = _state.asStateFlow();

    init {
        getAll()
    }

    private fun getAll(){
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            rickAndMortyUseCase.invoke().onRight { data ->
                _state.update {
                    it.copy(mainData = data.results)
                }
            }.onLeft {
                _state.update {
                    it.copy(errorMessage = it.errorMessage)
                }
            }
            _state.update {
                it.copy(isLoading = false)
            }
        }
    }
}