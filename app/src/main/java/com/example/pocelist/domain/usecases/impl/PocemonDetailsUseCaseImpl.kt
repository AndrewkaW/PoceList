package com.example.pocelist.domain.usecases.impl

import com.example.pocelist.domain.PocemonsRepository
import com.example.pocelist.domain.model.PocemonDetails
import com.example.pocelist.domain.usecases.PocemonDetailsUseCase
import com.example.pocelist.util.Resource
import kotlinx.coroutines.flow.Flow

class PocemonDetailsUseCaseImpl(private val repository: PocemonsRepository) :
    PocemonDetailsUseCase {
    override fun getPocemonDetails(name: String): Flow<Resource<PocemonDetails>> {
        return repository.getPocemonDetails(name)
    }
}