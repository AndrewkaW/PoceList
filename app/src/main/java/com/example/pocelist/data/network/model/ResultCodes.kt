package com.example.pocelist.data.network.model

enum class ResultCodes(val code: Int) {
    NO_NET_CONNECTION(500),
    SUCCESS(200),
    ERROR(400)
}