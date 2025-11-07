package com.jimd.randomuserapp.ui.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jimd.randomuserapp.domain.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repo:LocalRepository
):ViewModel() {

    var state by mutableStateOf(DetailState())

    fun getUserById(id:Int){
        state=state.copy(onLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
           repo.getUserById(id).onSuccess {
               state=state.copy(
                   onLoading = false,
                   user = it
               )

           }
        }
    }


}