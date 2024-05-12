package com.example.pocelist.di

import com.example.pocelist.data.PocemonsRepositoryImpl
import com.example.pocelist.domain.PocemonsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single <PocemonsRepository> {
        PocemonsRepositoryImpl()
    }
}