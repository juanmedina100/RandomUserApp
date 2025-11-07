package com.jimd.randomuserapp.data

import com.google.common.truth.Truth.assertThat
import com.jimd.randomuserapp.data.dao.UserDao
import com.jimd.randomuserapp.data.entities.Coordinates
import com.jimd.randomuserapp.data.entities.DateOfBirth
import com.jimd.randomuserapp.data.entities.Location
import com.jimd.randomuserapp.data.entities.Login
import com.jimd.randomuserapp.data.entities.Name
import com.jimd.randomuserapp.data.entities.Picture
import com.jimd.randomuserapp.data.entities.Registered
import com.jimd.randomuserapp.data.entities.Street
import com.jimd.randomuserapp.data.entities.Timezone
import com.jimd.randomuserapp.data.entities.UserEntity
import com.jimd.randomuserapp.data.model.ResponseUserDetailModel
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LocalRepositoryImplTest {


    @get:Rule
    val mockkRule = MockKRule(this)
    @RelaxedMockK
    private lateinit var userDao: UserDao

    private lateinit var repository: LocalRepositoryImpl

    @Before
    fun setUp() {
        repository = LocalRepositoryImpl(userDao)
    }



    @Test
    fun `insertUser should call dao's insertUser`() = runTest {
        // Given (Dado)
        val userEntity = user

        // When (Cuando)
        repository.insertUser(userEntity)

        // Then (Entonces)
        // Verificamos que la función 'insertUser' del DAO fue llamada exactamente una vez
        coVerify(exactly = 1) { userDao.insertUser(userEntity) }
    }

    @Test
    fun `getAllUsers should return a list of users from dao`() = runTest {
        // Given
        val expectedUsers = listOf(user)
        // Simulamos que cuando se llame a userDao.getAllUsers(), devuelva nuestra lista
        coEvery { userDao.getAllUsers() } returns expectedUsers

        // When
        val result = repository.getAllUsers()

        // Then
        assertThat(result).isEqualTo(expectedUsers)
    }

    @Test
    fun `getUserById should return user when found`() = runTest {
        // GIVEN (Dado que...)
        val userId = 1 // Usaremos un ID de ejemplo

        // Asignamos el ID a nuestra entidad de prueba para que coincida
        val userEntity = user.copy(id = userId)

        // Simulamos que el DAO devuelve nuestra entidad de prueba cuando se le pide por ese ID
        coEvery { userDao.getUserById(userId) } returns userEntity

        // Definimos el modelo de detalle que esperamos recibir después del mapeo en el repositorio.
        // Los datos deben coincidir con los de 'userEntity'.
        val expectedModel = ResponseUserDetailModel(
        gender = "male",
        name = Name(title = "Mr", first = "Juan", last = "Pérez"),
        location = userEntity.location, // Pasamos el objeto location completo
        email = "juan.perez@example.com",
        login = userEntity.login,
        dob = userEntity.dob,
        registered = userEntity.registered,
        phone = "+503 2222 3333",
        cell = "+503 7000 8000",
        idName = "DUI",
        idValue = "01234567-8",
        picture = userEntity.picture,
        nat = "SV"
        )

        // WHEN (Cuando...)
        // Ejecutamos la función del repositorio que estamos probando.
        val result = repository.getUserById(userId)

        // THEN (Entonces...)
        // Verificamos que la operación fue exitosa.
        assertThat(result.isSuccess).isTrue()

        // Verificamos que el objeto dentro del Result.success es exactamente el que esperamos.
        assertThat(result.getOrNull()).isEqualTo(expectedModel)
    }

    @Test
    fun `getUserById should return failure when dao throws an exception`() = runTest {
        // GIVEN
        val anyId = 123
        val dbException = RuntimeException("Database connection failed")
        coEvery { userDao.getUserById(anyId) } throws dbException

        // WHEN
        val result = repository.getUserById(anyId)

        // THEN
        assertThat(result.isFailure).isTrue()
        assertThat(result.exceptionOrNull()).isEqualTo(dbException)
    }

    @Test
    fun `deleteAllUsers should call dao's deleteAllUsers`() = runTest {
        // Given - No se necesita preparación

        // When
        repository.deleteAllUsers()

        // Then
        // Verificamos que el método correspondiente en el DAO fue llamado
        coVerify(exactly = 1) { userDao.deleteAllUsers() }
    }




    val user = UserEntity(
        id = 0, // Room lo autogenerará si usas autoGenerate = true
        uuid = "123e4567-e89b-12d3-a456-426614174000",
        gender = "male",
        name = Name(
            title = "Mr",
            first = "Juan",
            last = "Pérez"
        ),
        location = Location(
            street = Street(
                number = 123,
                name = "Calle Principal"
            ),
            city = "San Salvador",
            state = "San Salvador",
            country = "El Salvador",
            postcode = "1101",
            coordinates = Coordinates(
                latitude = "13.6929",
                longitude = "-89.2182"
            ),
            timezone = Timezone(
                offset = "-06:00",
                description = "Central America Standard Time"
            )
        ),
        email = "juan.perez@example.com",
        login = Login(
            username = "juanp",
            password = "securePass123",
            salt = "abc123",
            md5 = "5f4dcc3b5aa765d61d8327deb882cf99",
            sha1 = "7c4a8d09ca3762af61e59520943dc26494f8941b",
            sha256 = "ef797c8118f02dfb649607dd5d3f8c7623048c9c"
        ),
        dob = DateOfBirth(
            date = "1990-01-01T00:00:00Z",
            age = 35
        ),
        registered = Registered(
            date = "2020-01-01T00:00:00Z",
            age = 5
        ),
        phone = "+503 2222 3333",
        cell = "+503 7000 8000",
        idName = "DUI",
        idValue = "01234567-8",
        picture = Picture(
            large = "https://randomuser.me/api/portraits/men/1.jpg",
            medium = "https://randomuser.me/api/portraits/med/men/1.jpg",
            thumbnail = "https://randomuser.me/api/portraits/thumb/men/1.jpg"
        ),
        nat = "SV"
    )

}