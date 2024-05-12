package com.example.pocelist.data

import com.example.pocelist.data.network.model.PocemonDto
import com.example.pocelist.domain.FORMAT_IMAGE
import com.example.pocelist.domain.IMAGE_URL
import com.example.pocelist.domain.model.Pocemon

class AdapterPocemon {
    fun pocemonDtoToPocemon(dto: PocemonDto): Pocemon {
        return Pocemon(
            name = dto.name,
            imageUrl = extractIconUrl(dto.url)
        )
    }

    private fun extractIconUrl(url: String): String {
        val parts = url.split("/")
        val number = parts.last()
        return IMAGE_URL + number + FORMAT_IMAGE
        // return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png"
    }
}