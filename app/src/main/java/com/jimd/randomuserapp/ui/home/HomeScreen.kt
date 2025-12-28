package com.jimd.randomuserapp.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.AsyncImage
import com.jimd.randomuserapp.R
import com.jimd.randomuserapp.data.entities.UserEntity
import com.jimd.randomuserapp.ui.details.DetailScreen
import org.koin.androidx.compose.koinViewModel

class HomeScreen:Screen {
    @Composable
    override fun Content() {
        val viewModel: HomeViewModel = koinViewModel()
        val contexto = LocalContext.current
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { viewModel.getNetworkUser() }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ){padding->
            HomeApp(padding)
        }
    }
}

@Composable
fun HomeApp(padding: PaddingValues, viewModel: HomeViewModel= koinViewModel()){
    val navigation = LocalNavigator.currentOrThrow
    val state = viewModel.state
    val networkState = viewModel.networkState
    LaunchedEffect(Unit) {
        viewModel.getAllUsers()
    }
    Box(modifier=Modifier.fillMaxSize().padding(padding)){
        Column(modifier=Modifier.fillMaxWidth().padding(horizontal = 10.dp)) {
            if (state.isLoading){
                IsLoading()
            }else {
                LazyColumn {
                    items(state.users) {
                        ItemRandomUser(it) {
                            navigation.push(DetailScreen(it.id))
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun ItemRandomUser(userEntity: UserEntity,onClick:()->Unit= {}) {
    Card(modifier=Modifier.fillMaxWidth().padding(5.dp).clickable { onClick() },elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)) {
        Row(modifier=Modifier.padding(10.dp)) {
            AsyncImage(model = userEntity.picture.medium, contentDescription = "user",
                modifier=Modifier.width(60.dp).height(60.dp).clip(CircleShape),
                placeholder = painterResource(R.drawable.ic_launcher_foreground),
                error = painterResource(R.drawable.ic_launcher_foreground),
                contentScale = ContentScale.Crop
                )
            Column(modifier=Modifier.padding(start = 16.dp)) {
                Text(text = userEntity.name.first, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = userEntity.location.country, fontStyle = FontStyle.Normal, fontSize = 14.sp)
            }
        }
    }
}

@Composable
fun IsLoading(){
    Box(modifier=Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Column(modifier=Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            CircularProgressIndicator()
            Text("Loaging...")
        }
    }
}