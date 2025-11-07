package com.jimd.randomuserapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jimd.randomuserapp.data.dao.UserDao
import com.jimd.randomuserapp.data.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RandomUserDB:RoomDatabase() {
    abstract fun userDao(): UserDao
}