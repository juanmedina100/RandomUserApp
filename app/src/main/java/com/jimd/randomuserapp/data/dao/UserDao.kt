package com.jimd.randomuserapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.jimd.randomuserapp.data.entities.UserEntity

@Dao
interface UserDao {

    // Inserta o actualiza usuarios
    @Insert//(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    // Inserta varios usuarios
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<UserEntity>)

    // Obtiene todos los usuarios guardados
    @Query("SELECT * FROM users ORDER BY id ASC")
    suspend fun getAllUsers(): List<UserEntity>

    // Obtiene un usuario por su UUID
    @Query("SELECT * FROM users WHERE id = :id LIMIT 1")
    suspend fun getUserById(id: Int): UserEntity

    // Elimina todos los registros
    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()

    // Elimina un usuario específico
    @Delete
    suspend fun deleteUser(user: UserEntity)

}