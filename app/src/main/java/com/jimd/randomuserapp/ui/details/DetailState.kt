package com.jimd.randomuserapp.ui.details

import com.jimd.randomuserapp.data.model.ResponseUserDetailModel
import com.jimd.randomuserapp.data.model.results

data class DetailState(
    val onLoading:Boolean = false,
    val onError:String="",
    val gender: String="",
    val user:ResponseUserDetailModel = ResponseUserDetailModel()

)
