package com.jimd.randomuserapp.data.model

import com.jimd.randomuserapp.data.entities.DateOfBirth
import com.jimd.randomuserapp.data.entities.Location
import com.jimd.randomuserapp.data.entities.Login
import com.jimd.randomuserapp.data.entities.Name
import com.jimd.randomuserapp.data.entities.Picture
import com.jimd.randomuserapp.data.entities.Registered

data class ResponseUserDetailModel(
    val gender: String="",
    val name: Name = Name(),
    val location: Location=Location(),
    val email: String="",
    val login: Login=Login(),
    val dob: DateOfBirth=DateOfBirth(),
    val registered: Registered=Registered(),
    val phone: String="",
    val cell: String="",
    val idName: String="",
    val idValue:String="",
    val picture: Picture=Picture(),
    val nat: String=""
)
