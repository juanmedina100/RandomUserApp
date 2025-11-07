package com.jimd.randomuserapp.domain

import com.jimd.randomuserapp.data.model.ResponseData

interface RandomUserRerpository {

    suspend fun getNetworkUser():Result<ResponseData>
}