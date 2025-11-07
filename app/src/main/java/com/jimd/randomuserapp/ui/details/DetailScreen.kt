package com.jimd.randomuserapp.ui.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import coil.compose.AsyncImage
import coil.compose.SubcomposeAsyncImage
import org.koin.compose.viewmodel.koinViewModel
import org.koin.dsl.koinApplication

class DetailScreen(
    private val id:Int
):Screen {
    @Composable
    override fun Content() {
        Scaffold {padding->
            Details(id,padding)
        }
    }
}

@Composable
fun Details(id:Int,padding: PaddingValues,viewModel: DetailViewModel= koinViewModel()){
    val state=viewModel.state
    LaunchedEffect(Unit) {
        viewModel.getUserById(id)
    }
    Box(modifier=Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center){
        Column(modifier=Modifier.fillMaxWidth()) {
           AsyncImage(
               model = state.user.picture.large,
               contentDescription = null,
               modifier = Modifier
                   .width(100.dp)
                   .height(100.dp),
               contentScale = ContentScale.Crop
           )
            Text("${state.user.name.first} ${state.user.name.last}")
        }
    }
}