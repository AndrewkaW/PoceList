package com.example.pocelist.presentation.details.model

import com.example.pocelist.domain.model.PocemonDetails

sealed interface DetailsState {
    data object Loading : DetailsState

    data class Info(
        val details: PocemonDetails
    ) : DetailsState

    data class Error(
        val massage: String
    ) : DetailsState
}