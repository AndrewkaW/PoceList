package com.example.pocelist.domain.usecases.impl

import com.example.pocelist.domain.usecases.PocemonsListUseCase
import com.example.pocelist.domain.PocemonsRepository
import com.example.pocelist.domain.model.Pocemon
import com.example.pocelist.util.Resource
import kotlinx.coroutines.flow.Flow

class PocemonsListUseCaseImpl(private val repository: PocemonsRepository) : PocemonsListUseCase {
    override fun getPocemonsList(): Flow<Resource<List<Pocemon>>> {
        return repository.getPocemonsList()
    }
}