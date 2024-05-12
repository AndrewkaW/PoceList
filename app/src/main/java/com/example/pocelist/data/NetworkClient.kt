package com.example.pocelist.data

import com.example.pocelist.data.network.model.PokemonDetailsDto
import com.example.pocelist.data.network.model.Response

interface NetworkClient {
    suspend fun getPokemonList(): Response

    suspend fun getPokemonDetails(pokemonName: String): PokemonDetailsDto
}