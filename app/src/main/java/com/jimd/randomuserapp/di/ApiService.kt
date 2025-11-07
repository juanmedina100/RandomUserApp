package com.jimd.randomuserapp.di

import io.ktor.client.HttpClient

class ApiService(
    private val httpClient: HttpClient,
) {

    companion object {
        const val URL = ""
    }

}