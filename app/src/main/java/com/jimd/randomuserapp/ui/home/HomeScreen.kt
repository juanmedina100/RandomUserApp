package com.jimd.randomuserapp.ui.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen

class HomeScreen:Screen {
    @Composable
    override fun Content() {
        val contexto = LocalContext.current
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = { Toast.makeText(contexto,"Floating Action Button",Toast.LENGTH_SHORT).show() }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ){padding->
            HomeApp(padding)
        }
    }
}

@Composable
fun HomeApp(padding: PaddingValues){
    Box(modifier=Modifier.fillMaxSize().padding(padding)){
        Column(modifier=Modifier.fillMaxWidth()) {
            Text(text = "Home", fontSize = 32.sp)
        }
    }
}