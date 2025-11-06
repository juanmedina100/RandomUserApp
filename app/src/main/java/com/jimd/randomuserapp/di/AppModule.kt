package com.jimd.randomuserapp.di

import org.koin.dsl.module

val appModule = module {
    includes(networkModule)//repositorioModulo, viewModelModule,roomModule
}