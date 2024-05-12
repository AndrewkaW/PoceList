package com.example.pocelist.data.list

import com.example.pocelist.data.AdapterPocemon
import com.example.pocelist.data.NetworkClient
import com.example.pocelist.domain.PocemonsRepository

class PocemonsRepositoryImpl(
    private val networkClient: NetworkClient,
    private val adapterPocemon: AdapterPocemon
) : PocemonsRepository {

}