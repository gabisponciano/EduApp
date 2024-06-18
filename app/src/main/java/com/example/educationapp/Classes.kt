package com.example.educationapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.educationapp.components.HeaderCourse
import com.example.educationapp.components.SearchBarUi

@Composable
fun Classes(navController: NavController){

    var query by remember { mutableStateOf("") }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        HeaderCourse(text = "Aulas", navController, title = "Back")
        SearchBarUi(query = query,
            onQueryChange = {query = it}
            )
        Spacer(modifier = Modifier.height(12.dp))
        ConteudoAula(title = "Python", description = "dcjsiufke cskrbg sbkve rg cbkbrg vsbhrmfg em vjdebmtg  cdbmr " )


    }

}
@Preview
@Composable
fun ClassesPreview(){
    val navController = rememberNavController()
    Classes(navController)
}