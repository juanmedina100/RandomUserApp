package com.jimd.randomuserapp.domain

import com.jimd.randomuserapp.data.entities.UserEntity
import com.jimd.randomuserapp.data.model.ResponseUserDetailModel

interface LocalRepository {

    suspend fun insertUser(user: UserEntity)
    suspend fun insertUsers(users: List<UserEntity>)

    suspend fun getAllUsers(): List<UserEntity>

    suspend fun getUserById(id: Int): Result<ResponseUserDetailModel>

    suspend fun deleteAllUsers()

    suspend fun deleteUser(user: UserEntity)

}