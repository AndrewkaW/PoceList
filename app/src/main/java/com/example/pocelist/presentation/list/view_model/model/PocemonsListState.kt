package com.example.pocelist.presentation.list.view_model.model

import com.example.pocelist.domain.model.Pocemon

sealed interface PocemonsListState {
    data object Loading : PocemonsListState

    data class PocemonsResult(
        val pocemons: List<Pocemon>
    ) : PocemonsListState

    data class Error(
        val massage: String
    )
}