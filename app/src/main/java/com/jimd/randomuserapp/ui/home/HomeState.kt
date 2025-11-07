package com.jimd.randomuserapp.ui.home

import com.jimd.randomuserapp.data.entities.UserEntity

data class HomeState(
    val isLoading: Boolean = false,
    val users: List<UserEntity> = emptyList(),
    val error: String = ""
)
