package com.jimd.randomuserapp.data

import com.jimd.randomuserapp.di.ApiService
import com.jimd.randomuserapp.domain.RandomUserRerpository

class RandomUserRepositoryImpl(
    private val api:ApiService
):RandomUserRerpository {

}