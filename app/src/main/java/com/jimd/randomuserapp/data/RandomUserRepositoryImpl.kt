package com.jimd.randomuserapp.data

import com.jimd.randomuserapp.data.model.ResponseData
import com.jimd.randomuserapp.data.model.results
import com.jimd.randomuserapp.di.ApiService
import com.jimd.randomuserapp.domain.RandomUserRerpository

class RandomUserRepositoryImpl(
    private val api:ApiService
):RandomUserRerpository {
    override suspend fun getNetworkUser(): Result<ResponseData> {
        return api.getNetworkUser()
    }

}