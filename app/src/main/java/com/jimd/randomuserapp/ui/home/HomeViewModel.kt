package com.jimd.randomuserapp.ui.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.randomuserapp.data.entities.UserEntity
import com.jimd.randomuserapp.data.model.Name
import com.jimd.randomuserapp.data.model.results
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
        viewModelScope.launch(Dispatchers.IO) {
            val users = localRepository.getAllUsers()
            state=state.copy(
                isLoading = true,
                users = users,
                error = ""
            )
        }
    }
    fun getNetworkUser(){
        viewModelScope.launch(Dispatchers.IO) {
            networkState=networkState.copy(onLoading = true)
            randomUserRepository.getNetworkUser().onSuccess {
                Log.i("nett","onSuccess ${it}")
                networkState=networkState.copy(
                    onLoading = false,
                    name = it.results[0].name.first,
                    location = it.results[0].location.city,
                    results = it.results[0]
                )
                insertUser()
            }.onFailure {
                Log.i("nett",it.toString())
                networkState=networkState.copy(
                    onLoading = false,
                    error = it.message.toString()
                )
            }
        }
    }

    fun insertUser(){
        viewModelScope.launch(Dispatchers.IO) {
// 1. Asegúrate de que hay un usuario para guardar
            val userToInsert = networkState.results
            if (userToInsert != null) {
                // 2. Mapea el objeto 'Result' de la red a tu 'UserEntity' local
                val userEntity = UserEntity(
                    // Room generará el ID automáticamente, así que lo dejamos en 0
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

                // 3. Llama al repositorio para insertar la entidad en la base de datos
                localRepository.insertUser(userEntity)

                // 4. (Opcional pero recomendado) Actualiza la lista de usuarios en la UI
                getAllUsers()

                Log.i("DB_INSERT", "Usuario insertado: $userEntity")
            } else {
                Log.w("DB_INSERT", "No se encontró ningún usuario en el estado de red para insertar.")
            }

        }
    }

}