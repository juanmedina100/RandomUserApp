package com.jimd.randomuserapp.domain

import com.jimd.randomuserapp.data.entities.UserEntity

interface LocalRepository {

    suspend fun insertUser(user: UserEntity)
    suspend fun insertUsers(users: List<UserEntity>)

    suspend fun getAllUsers(): List<UserEntity>

    suspend fun getUserById(uuid: String): UserEntity?

    suspend fun deleteAllUsers()

    suspend fun deleteUser(user: UserEntity)

}