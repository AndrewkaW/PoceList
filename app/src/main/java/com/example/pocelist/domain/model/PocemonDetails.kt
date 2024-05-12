package com.example.pocelist.domain.model

import com.example.pocelist.data.network.model.Sprites

data class PocemonDetails(
    val name: String,
    val height: Int,
    val weight: Int,
    val types: String,
    val abilities: String,
    val imageUrl: String
)