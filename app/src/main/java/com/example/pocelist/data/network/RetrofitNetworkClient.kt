package com.example.pocelist.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.TRANSPORT_CELLULAR
import android.net.NetworkCapabilities.TRANSPORT_ETHERNET
import android.net.NetworkCapabilities.TRANSPORT_WIFI
import com.example.pocelist.data.NetworkClient
import com.example.pocelist.data.network.model.PokemonDetailsDto
import com.example.pocelist.data.network.model.Response
import com.example.pocelist.data.network.model.ResultCodes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RetrofitNetworkClient(
    private val context: Context,
    private val pokemonApi: PocemonsApi
) : NetworkClient {
    override suspend fun getPokemonList(): Response {
        if (!isConnected()) {
            return Response().apply { responseCode = ResultCodes.NO_NET_CONNECTION }
        }

        return withContext(Dispatchers.IO) {
            try {
                val response = pokemonApi.getPokemonList()
                response.apply { responseCode = ResultCodes.SUCCESS }
            } catch (e: Throwable) {
                Response().apply { responseCode = ResultCodes.ERROR }
            }
        }
    }

    override suspend fun getPokemonDetails(pokemonName: String): PokemonDetailsDto {
        TODO("Not yet implemented")
    }

    private fun isConnected(): Boolean {
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        return capabilities?.let {
            it.hasTransport(TRANSPORT_CELLULAR) ||
                    it.hasTransport(TRANSPORT_WIFI) ||
                    it.hasTransport(TRANSPORT_ETHERNET)
        } ?: false
    }
}