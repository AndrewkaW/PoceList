package com.example.pocelist.domain

import com.example.pocelist.domain.model.Pocemon
import com.example.pocelist.util.Resource
import kotlinx.coroutines.flow.Flow

interface PocemonsListUseCase {
    fun getPocemonsList(): Flow<Resource<List<Pocemon>>>
}