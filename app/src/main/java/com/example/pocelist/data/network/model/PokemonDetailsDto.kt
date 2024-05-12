package com.example.pocelist.data.network.model

data class PokemonDetailsDto(
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<Type>,
    val abilities: List<Ability>,
    val baseExperience: Int,
    val sprites: Sprites
)

data class Type(
    val type: TypeName
)

data class TypeName(
    val name: String
)

data class Ability(
    val ability: AbilityName
)

data class AbilityName(
    val name: String
)

data class Sprites(
    val front_default: String
)
