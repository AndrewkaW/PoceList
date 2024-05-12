package com.example.pocelist.di

import com.example.pocelist.data.AdapterPocemon
import com.example.pocelist.data.network.PocemonsApi
import com.example.pocelist.domain.POCEMON_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single<PocemonsApi> {

        Retrofit.Builder()
            .baseUrl(POCEMON_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PocemonsApi::class.java)
    }

    single { AdapterPocemon() }
}