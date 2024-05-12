package com.example.pocelist.data

import com.example.pocelist.data.network.model.Ability
import com.example.pocelist.data.network.model.PocemonDto
import com.example.pocelist.data.network.model.PokemonDetailsDto
import com.example.pocelist.data.network.model.Type
import com.example.pocelist.util.FORMAT_IMAGE
import com.example.pocelist.util.IMAGE_URL
import com.example.pocelist.domain.model.Pocemon
import com.example.pocelist.domain.model.PocemonDetails

class AdapterPocemon {
    fun pocemonDtoToPocemon(dto: PocemonDto): Pocemon {
        return Pocemon(
            name = dto.name,
            imageUrl = extractIconUrl(dto.url)
        )
    }

    fun pocemonDetailsDtoToPocemonDetails(dto: PokemonDetailsDto): PocemonDetails {
        return PocemonDetails(
            name = dto.name,
            height = dto.height,
            weight = dto.weight,
            types = formatListToString(dto.types),
            abilities = formatListToString(dto.abilities),
            imageUrl = dto.sprites.front_default

        )
    }

    private fun extractIconUrl(url: String): String {
        val parts = url.split("/")
        val number = parts[parts.size - 2]
        return IMAGE_URL + number + FORMAT_IMAGE
    }

    private fun formatListToString(list: List<Any>): String {
        val names = list.joinToString(", ") { item ->
            when (item) {
                is Type -> item.type.name
                is Ability -> item.ability.name
                else -> ""
            }
        }
        return "$names."
    }
}