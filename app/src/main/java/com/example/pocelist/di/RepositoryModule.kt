package com.example.pocelist.di

import com.example.pocelist.data.impl.PocemonsRepositoryImpl
import com.example.pocelist.domain.PocemonsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<PocemonsRepository> {
        PocemonsRepositoryImpl(get(), get())
    }
}