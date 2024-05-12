package com.example.pocelist.presentation.details.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocelist.domain.model.PocemonDetails
import com.example.pocelist.domain.usecases.PocemonDetailsUseCase
import com.example.pocelist.presentation.details.model.DetailsState
import com.example.pocelist.util.Resource
import kotlinx.coroutines.launch

class PocemonDetailsViewModel(
    private val detailsUseCase: PocemonDetailsUseCase
) : ViewModel() {

    private val _stateLiveData = MutableLiveData<DetailsState>()
    val stateLiveData: LiveData<DetailsState> get() = _stateLiveData

    fun getPocemonDetails(name: String){
        viewModelScope.launch {
            detailsUseCase.getPocemonDetails(name).collect{
                processResult(it)
            }
        }
    }
    private fun processResult(resource: Resource<PocemonDetails>) {
        _stateLiveData.postValue(DetailsState.Loading)
        when (resource) {
            is Resource.Success -> {
                    _stateLiveData.postValue(DetailsState.Info(resource.data!!))
                }

            is Resource.Error -> {
                _stateLiveData.postValue(DetailsState.Error(resource.message!!))
            }
        }
    }
}