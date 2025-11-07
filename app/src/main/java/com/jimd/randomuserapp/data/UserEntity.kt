package com.jimd.randomuserapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Embedded

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val uuid: String, // viene de login.uuid
    val gender: String,
    @Embedded(prefix = "name_") val name: Name,
    @Embedded(prefix = "location_") val location: Location,
    val email: String,
    @Embedded(prefix = "login_") val login: Login,
    @Embedded(prefix = "dob_") val dob: DateOfBirth,
    @Embedded(prefix = "registered_") val registered: Registered,
    val phone: String,
    val cell: String,
    val idName: String?,
    val idValue: String?,
    @Embedded(prefix = "picture_") val picture: Picture,
    val nat: String
)

/* ---------- Subclases ---------- */

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Location(
    @Embedded(prefix = "street_") val street: Street,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    @Embedded(prefix = "coordinates_") val coordinates: Coordinates,
    @Embedded(prefix = "timezone_") val timezone: Timezone
)

data class Street(
    val number: Int,
    val name: String
)

data class Coordinates(
    val latitude: String,
    val longitude: String
)

data class Timezone(
    val offset: String,
    val description: String
)

data class Login(
    val username: String,
    val password: String,
    val salt: String,
    val md5: String,
    val sha1: String,
    val sha256: String
)

data class DateOfBirth(
    val date: String,
    val age: Int
)

data class Registered(
    val date: String,
    val age: Int
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)
