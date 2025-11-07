package com.jimd.randomuserapp.di

import com.jimd.randomuserapp.data.LocalRepositoryImpl
import com.jimd.randomuserapp.data.RandomUserRepositoryImpl
import com.jimd.randomuserapp.data.dao.UserDao
import com.jimd.randomuserapp.domain.LocalRepository
import com.jimd.randomuserapp.domain.RandomUserRerpository
import org.koin.dsl.module

val repositoryModule = module {
    single { provideRandomUserRepository(get()) }
    single { provideLocalRepository(get()) }
}

fun provideRandomUserRepository(apiService: ApiService):RandomUserRerpository{
    return RandomUserRepositoryImpl(apiService)
}

fun provideLocalRepository(userDao: UserDao):LocalRepository{
    return LocalRepositoryImpl(userDao)
}


