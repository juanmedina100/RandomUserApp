package com.jimd.randomuserapp.di

import androidx.room.Room
import com.jimd.randomuserapp.data.RandomUserDB
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(get(),
            RandomUserDB::class.java, "randomUser_db").build()
    }
    single { get<RandomUserDB>().userDao() }
}