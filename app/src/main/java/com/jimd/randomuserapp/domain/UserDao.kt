package com.jimd.randomuserapp.domain

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jimd.randomuserapp.data.UserEntity

@Dao
interface UserDao {

    // Inserta o actualiza usuarios
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    // Inserta varios usuarios
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)

    // Obtiene todos los usuarios guardados
    @Query("SELECT * FROM users ORDER BY name_first ASC")
    suspend fun getAllUsers(): List<UserEntity>

    // Obtiene un usuario por su UUID
    @Query("SELECT * FROM users WHERE uuid = :uuid LIMIT 1")
    suspend fun getUserById(uuid: String): UserEntity?

    // Elimina todos los registros
    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()

    // Elimina un usuario específico
    @Delete
    suspend fun deleteUser(user: UserEntity)

}