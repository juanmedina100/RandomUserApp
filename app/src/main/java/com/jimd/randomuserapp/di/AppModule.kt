package com.jimd.randomuserapp.di

import org.koin.dsl.module

val appModule = listOf(networkModule, repositoryModule, roomModule)
