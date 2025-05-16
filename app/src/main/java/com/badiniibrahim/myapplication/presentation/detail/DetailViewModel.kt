package com.badiniibrahim.myapplication.presentation.detail

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
class DetailViewModel @Inject constructor(
    private val rickAndMortyUseCase: RickAndMortyUseCase
):ViewModel() {
    private val _state = MutableStateFlow(DetailViewState())
    val state = _state.asStateFlow();


    fun getById(id:Int){
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }
            rickAndMortyUseCase.invokeById(id).onRight { data ->
                _state.update {
                    it.copy(mainData = data)
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