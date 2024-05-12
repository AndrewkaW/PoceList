package com.example.pocelist.data.network

import com.example.pocelist.data.network.model.PocemonDetailsResponse
import com.example.pocelist.data.network.model.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PocemonsApi {
    @GET("pokemon?limit=100000&offset=0")
    suspend fun getPokemonList(): PokemonListResponse

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonDetails(@Path("pokemonName") pokemonName: String): PocemonDetailsResponse
}