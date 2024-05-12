package com.example.pocelist.presentation.list.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pocelist.domain.usecases.PocemonsListUseCase
import com.example.pocelist.domain.model.Pocemon
import com.example.pocelist.presentation.list.view_model.model.PocemonsListState
import com.example.pocelist.util.Resource
import kotlinx.coroutines.launch

class PocemonsListViewModel(private val useCase: PocemonsListUseCase) : ViewModel() {

    private val _stateLiveData = MutableLiveData<PocemonsListState>()
    val stateLiveData: LiveData<PocemonsListState> get() = _stateLiveData

    init {
        getPocemonsList()
    }

    fun getPocemonsList() {
        viewModelScope.launch {
            useCase.getPocemonsList().collect {
                processResult(it)
            }
        }
    }

    private fun processResult(resource: Resource<List<Pocemon>>) {
        when (resource) {
            is Resource.Success -> {
                val pocemons = mutableListOf<Pocemon>()
                if (resource.data != null) {
                    pocemons.addAll(resource.data)
                    _stateLiveData.postValue(PocemonsListState.PocemonsResult(pocemons))
                } else _stateLiveData.postValue(PocemonsListState.Error(Resource.NOT_FOUND))
            }

            is Resource.Error -> {
                _stateLiveData.postValue(PocemonsListState.Error(resource.message!!))
            }
        }
    }

}