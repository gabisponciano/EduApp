package com.example.educationapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.educationapp.components.HeaderLog
import com.example.educationapp.components.HeaderLog

@Composable
fun LogIn(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
    ){
        HeaderLog(text = "Log In")

        Column (

        ){

        }

    }

}

@Preview
@Composable
fun LogInPreview(){
    val navController = rememberNavController()
    LogIn(navController)
}