package com.example.pocelist.di

import com.example.pocelist.domain.usecases.PocemonDetailsUseCase
import com.example.pocelist.domain.usecases.PocemonsListUseCase
import com.example.pocelist.domain.usecases.impl.PocemonDetailsUseCaseImpl
import com.example.pocelist.domain.usecases.impl.PocemonsListUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    factory<PocemonsListUseCase> {
        PocemonsListUseCaseImpl(get())
    }

    factory<PocemonDetailsUseCase> {
        PocemonDetailsUseCaseImpl(get())
    }
}