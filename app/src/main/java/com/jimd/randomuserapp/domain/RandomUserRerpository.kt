package com.jimd.randomuserapp.domain

import com.jimd.randomuserapp.data.entities.UserEntity
import com.jimd.randomuserapp.data.model.ResponseData
import com.jimd.randomuserapp.data.model.results

interface RandomUserRerpository {

    suspend fun getNetworkUser():Result<ResponseData>
}