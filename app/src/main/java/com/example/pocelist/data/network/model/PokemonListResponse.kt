package com.example.pocelist.data.network.model

data class PokemonListResponse(
    val count : Int,
    val results : List<PocemonDto>
) : Response()