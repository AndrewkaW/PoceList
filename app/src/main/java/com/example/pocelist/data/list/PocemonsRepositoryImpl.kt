package com.example.pocelist.data.list

import com.example.pocelist.data.AdapterPocemon
import com.example.pocelist.data.NetworkClient
import com.example.pocelist.data.network.model.PokemonListResponse
import com.example.pocelist.data.network.model.ResultCodes
import com.example.pocelist.domain.PocemonsRepository
import com.example.pocelist.domain.model.Pocemon
import com.example.pocelist.util.Resource
import com.example.pocelist.util.Resource.Companion.CONNECTION_ERROR
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PocemonsRepositoryImpl(
    private val networkClient: NetworkClient,
    private val adapterPocemon: AdapterPocemon
) : PocemonsRepository {
    override fun getPocemonsList(): Flow<Resource<List<Pocemon>>> = flow {
        val response = networkClient.getPokemonList()

        when (response.responseCode) {
            ResultCodes.ERROR -> {
                emit(Resource.Error(CONNECTION_ERROR))
            }

            ResultCodes.SUCCESS -> {
                val listResponse = response as PokemonListResponse
                if (listResponse.results.isEmpty()) {
                    emit(Resource.Error(Resource.NOT_FOUND))
                } else {
                    val data = listResponse.results.map {
                        adapterPocemon.pocemonDtoToPocemon(it)
                    }
                    emit(Resource.Success(data))
                }
            }

            else -> {
                emit(Resource.Error(CONNECTION_ERROR))
            }
        }
    }
}