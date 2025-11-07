package com.jimd.randomuserapp.data

import com.jimd.randomuserapp.data.dao.UserDao
import com.jimd.randomuserapp.data.entities.UserEntity
import com.jimd.randomuserapp.data.model.ResponseUserDetailModel
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

    override suspend fun getUserById(id: Int): Result<ResponseUserDetailModel> {
        return try {
            val userEntity = userDao.getUserById(id)
            if (userEntity!=null){
                val user = ResponseUserDetailModel(
                    gender = userEntity.gender,
                    name = userEntity.name,
                    location = userEntity.location,
                    email = userEntity.email,
                    login = userEntity.login,
                    dob = userEntity.dob,
                    registered = userEntity.registered,
                    phone = userEntity.phone,
                    cell = userEntity.cell,
                    idName = userEntity.idName ?: "",
                    idValue = userEntity.idValue ?: "",
                    picture = userEntity.picture,
                    nat = userEntity.nat
                )
                Result.success(user
                )
            }else{
                Result.failure(Exception("User not found"))
            }
        }catch (e:Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }

    override suspend fun deleteAllUsers() {
        userDao.deleteAllUsers()
    }

    override suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }
}