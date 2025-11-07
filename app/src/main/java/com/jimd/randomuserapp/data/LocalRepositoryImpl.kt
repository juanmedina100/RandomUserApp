package com.jimd.randomuserapp.data

import com.jimd.randomuserapp.data.dao.UserDao
import com.jimd.randomuserapp.data.entities.UserEntity
import com.jimd.randomuserapp.domain.LocalRepository

class LocalRepositoryImpl(
    private val userDao: UserDao
):LocalRepository {
    override suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    override suspend fun insertUsers(users: List<UserEntity>) {
        userDao.insertUsers(users)
    }

    override suspend fun getAllUsers(): List<UserEntity> {
        return userDao.getAllUsers()
    }

    override suspend fun getUserById(uuid: String): UserEntity? {
        return userDao.getUserById(uuid)
    }

    override suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }

    override suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }
}