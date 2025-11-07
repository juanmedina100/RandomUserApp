package com.jimd.randomuserapp.di

import android.util.Log
import com.jimd.randomuserapp.data.model.ResponseData
import com.jimd.randomuserapp.data.model.results
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.statement.bodyAsText

class ApiService(
    private val httpClient: HttpClient,
) {

    companion object {
        const val URL = "https://randomuser.me/api/"
    }

    suspend fun getNetworkUser():Result<ResponseData>{
        return try {
            val user = httpClient.get(URL){
                headers {
                    append("Content-Type", "application/json;charset=UTF-8")
//                    append("Accept", "application/json")
                }
            }
//                .body<ResponseData>()
            val response = user.body<ResponseData>()
            Log.i("user_d",user.status.value.toString())
            if (user.status.value==200){
                Log.i("user_d",user.bodyAsText())
                Log.i("user_d",response.toString())
            }
            Result.success(response)
        }catch (e:Exception){
            e.printStackTrace()
            Result.failure(e)
        }
    }

}