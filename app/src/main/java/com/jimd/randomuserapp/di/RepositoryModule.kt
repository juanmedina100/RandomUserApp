package com.jimd.randomuserapp.di

import com.jimd.randomuserapp.data.RandomUserRepositoryImpl
import com.jimd.randomuserapp.domain.RandomUserRerpository
import org.koin.dsl.module

val repositoryModule = module {
    single { provideRandomUserRepository(get()) }
}

fun provideRandomUserRepository(apiService: ApiService):RandomUserRerpository{
    return RandomUserRepositoryImpl(apiService)
}


