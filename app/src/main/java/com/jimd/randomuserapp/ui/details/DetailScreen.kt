package com.jimd.randomuserapp.ui.details

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.AsyncImage
import com.jimd.randomuserapp.ui.util.formatIsoDateString
import org.koin.compose.viewmodel.koinViewModel

class DetailScreen(
    private val id:Int
):Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.O)
    @Composable
    override fun Content() {
        val navigation = LocalNavigator.currentOrThrow
        Scaffold(
            topBar = {
                TopAppBar(title = {Text("User Details",modifier=Modifier.fillMaxWidth(), textAlign = TextAlign.Center)},
                    navigationIcon = { IconButton(onClick = { navigation.pop() }){
                        Icon(Icons.Default.ArrowBack, contentDescription = "")
                    } }, modifier = Modifier.height(56.dp))
            }
        ) {padding->
            Details(id,padding)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Details(id:Int,padding: PaddingValues,viewModel: DetailViewModel= koinViewModel()){
    val state=viewModel.state
    LaunchedEffect(Unit) {
        viewModel.getUserById(id)
    }
    Box(modifier=Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.TopCenter){
        Column(modifier=Modifier.fillMaxWidth().padding(16.dp).verticalScroll(rememberScrollState()), horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.height(16.dp))
            AsyncImage(
               model = state.user.picture.large,
               contentDescription = null,
               modifier = Modifier
                   .width(160.dp)
                   .height(160.dp).clip(CircleShape),
               contentScale = ContentScale.Crop
           )
            Spacer(modifier = Modifier.height(16.dp))
            Text("${state.user.name.first} ${state.user.name.last}", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Text(state.user.gender, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            CardDetail(Icons.Default.DateRange,state.user.dob.age.toString()+" years old",
                formatIsoDateString(state.user.dob.date).toString()
            )
            Spacer(modifier = Modifier.height(6.dp))
            CardDetail(Icons.Default.LocationOn, "${state.user.location.street.name}, ${state.user.location.street.name}", "${state.user.location.city}, ${state.user.location.country}")
            Spacer(modifier = Modifier.height(6.dp))
            CardDetail(Icons.Default.Email, state.user.email, "Email")
            Spacer(modifier = Modifier.height(6.dp))
            CardDetail(Icons.Default.Phone, state.user.phone, "Phone")
            Spacer(modifier = Modifier.height(6.dp))
            CardDetail(Icons.Default.Person, state.user.login.username, "User")
        }
    }



}


@Composable
fun CardDetail(icons: ImageVector, title: String, value: String) {
    Card(modifier=Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
        Row(modifier=Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(imageVector = icons, contentDescription = "",
                modifier=Modifier.clip(RoundedCornerShape(10.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .padding(16.dp),
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                )
            Column(modifier=Modifier.padding(8.dp), horizontalAlignment = Alignment.Start) {
                Text(text = title, fontWeight = FontWeight.Bold)
                Text(text = value)
            }
        }
    }
}