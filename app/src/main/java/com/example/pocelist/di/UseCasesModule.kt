package com.example.pocelist.di

import com.example.pocelist.domain.PocemonsListUseCase
import com.example.pocelist.domain.impl.PocemonsListUseCaseImpl
import org.koin.dsl.module

val useCasesModule = module {
    single <PocemonsListUseCase>{
        PocemonsListUseCaseImpl(get())
    }
}