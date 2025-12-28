package com.jimd.randomuserapp.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.randomuserapp.data.entities.UserEntity
import com.jimd.randomuserapp.domain.LocalRepository
import com.jimd.randomuserapp.domain.RandomUserRerpository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val randomUserRepository: RandomUserRerpository,
    private val localRepository: LocalRepository
): ViewModel() {

    var state by mutableStateOf(HomeState())
    var networkState by mutableStateOf(HomeNetworkState())

    fun getAllUsers(){
        state=state.copy(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            val users = localRepository.getAllUsers()
            state=state.copy(
                isLoading = false,
                users = users,
                error = ""
            )
        }
    }
    fun getNetworkUser(){
        viewModelScope.launch(Dispatchers.IO) {
            randomUserRepository.getNetworkUser().onSuccess {
                networkState=networkState.copy(
                    name = it.results[0].name.first,
                    location = it.results[0].location.city,
                    results = it.results[0]
                )
                insertUser()
            }.onFailure {
                networkState=networkState.copy(
                    error = it.message.toString()
                )
            }
        }
    }

    fun insertUser(){
        viewModelScope.launch(Dispatchers.IO) {
            val userToInsert = networkState.results
            if (userToInsert != null) {
                val userEntity = UserEntity(
                    id = 0,
                    uuid = userToInsert.uuid,
                    gender = userToInsert.gender,
                    name = userToInsert.name,
                    location = userToInsert.location,
                    email = userToInsert.email,
                    login = userToInsert.login,
                    dob = userToInsert.dob,
                    registered = userToInsert.registered,
                    phone = userToInsert.phone,
                    cell = userToInsert.cell,
                    idName = userToInsert.idName,
                    idValue = userToInsert.idValue,
                    picture = userToInsert.picture,
                    nat = userToInsert.nat
                )

                localRepository.insertUser(userEntity)

                getAllUsers()

            } else {
                Log.w("DB_INSERT", "No se encontró ningún usuario en el estado de red para insertar.")
            }

        }
    }

}