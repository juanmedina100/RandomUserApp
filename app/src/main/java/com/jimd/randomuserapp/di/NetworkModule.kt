package com.jimd.randomuserapp.di

import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule = module {
    single { provideHttpClient() }
//    single { provideService(get()) }
}

fun provideHttpClient(): HttpClient {
    return httpClientAndroid
}
//fun provideService(httpClient: HttpClient): ApiService {
//    return ApiService(httpClient)
//}