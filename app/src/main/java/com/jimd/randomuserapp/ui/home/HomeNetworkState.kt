package com.jimd.randomuserapp.ui.home

import com.jimd.randomuserapp.data.model.results

data class HomeNetworkState(
    val onLoading:Boolean=false,
    val name:String="",
    val location:String="",
    val error:String="",
    val results:results = results()
)
