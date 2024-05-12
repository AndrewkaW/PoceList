package com.example.pocelist.di

import com.example.pocelist.data.AdapterPocemon
import com.example.pocelist.data.NetworkClient
import com.example.pocelist.data.network.PocemonsApi
import com.example.pocelist.data.network.RetrofitNetworkClient
import com.example.pocelist.util.POCEMON_URL
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

    single<NetworkClient> {
        RetrofitNetworkClient(get(), get())
    }
}