package com.jimd.randomuserapp.data.model

import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.jimd.randomuserapp.data.entities.DateOfBirth
import com.jimd.randomuserapp.data.entities.Location
import com.jimd.randomuserapp.data.entities.Login
import com.jimd.randomuserapp.data.entities.Name
import com.jimd.randomuserapp.data.entities.Picture
import com.jimd.randomuserapp.data.entities.Registered
import kotlinx.serialization.Serializable

@Serializable
data class ResponseData(
    val results: List<results>,
    val info: info
)

@Serializable
data class info(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)

@Serializable
data class results(
    val uuid: String="", // viene de login.uuid
    val gender: String="",
    @Embedded(prefix = "name_") val name: Name=Name(),
    @Embedded(prefix = "location_") val location: Location=Location(),
    val email: String="",
    @Embedded(prefix = "login_") val login: Login=Login(),
    @Embedded(prefix = "dob_") val dob: DateOfBirth=DateOfBirth(),
    @Embedded(prefix = "registered_") val registered: Registered= Registered(),
    val phone: String="",
    val cell: String="",
    val idName: String?="",
    val idValue: String?="",
    @Embedded(prefix = "picture_") val picture: Picture=Picture(),
    val nat: String=""
)

/* ---------- Subclases ---------- */
@Serializable
data class Name(
    val title: String="",
    val first: String="",
    val last: String=""
)
@Serializable
data class Location(
    @Embedded(prefix = "street_") val street: Street=Street(),
    val city: String="",
    val state: String="",
    val country: String="",
    val postcode: String="",
    @Embedded(prefix = "coordinates_") val coordinates: Coordinates=Coordinates(),
    @Embedded(prefix = "timezone_") val timezone: Timezone=Timezone()
)
@Serializable
data class Street(
    val number: Int=0,
    val name: String=""
)
@Serializable
data class Coordinates(
    val latitude: String="",
    val longitude: String=""
)
@Serializable
data class Timezone(
    val offset: String="",
    val description: String=""
)
@Serializable
data class Login(
    val username: String="",
    val password: String="",
    val salt: String="",
    val md5: String="",
    val sha1: String="",
    val sha256: String=""
)
@Serializable
data class DateOfBirth(
    val date: String="",
    val age: Int=0
)
@Serializable
data class Registered(
    val date: String="",
    val age: Int=0
)
@Serializable
data class Picture(
    val large: String="",
    val medium: String="",
    val thumbnail: String=""
)
