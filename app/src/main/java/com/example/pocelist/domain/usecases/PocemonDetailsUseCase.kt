package com.example.pocelist.domain.usecases

import com.example.pocelist.domain.model.PocemonDetails
import com.example.pocelist.util.Resource
import kotlinx.coroutines.flow.Flow

interface PocemonDetailsUseCase {
    fun getPocemonDetails(name: String): Flow<Resource<PocemonDetails>>
}