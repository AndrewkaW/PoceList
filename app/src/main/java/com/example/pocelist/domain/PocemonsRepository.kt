package com.example.pocelist.domain

import com.example.pocelist.domain.model.Pocemon
import com.example.pocelist.domain.model.PocemonDetails
import com.example.pocelist.util.Resource
import kotlinx.coroutines.flow.Flow

interface PocemonsRepository {
    fun getPocemonsList(): Flow<Resource<List<Pocemon>>>
    fun getPocemonDetailes(name: String): Flow<Resource<PocemonDetails>>
}