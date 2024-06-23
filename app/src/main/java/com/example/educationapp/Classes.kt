package com.example.educationapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.educationapp.components.HeaderCourse
import com.example.educationapp.components.SearchBarUi
import com.example.educationapp.components.Slider
import com.example.educationapp.viewmodels.ClassViewModel

@Composable
fun Classes(navController: NavController) {
    val classViewModel = viewModel<ClassViewModel>()

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 70.dp), // Adiciona espaço para o NavApp
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HeaderCourse(text = "Classes", navController, title = "Back")

            SearchBarUi(
                query = classViewModel.query.value,
                onQueryChange = { classViewModel.queryUser(it) }
            )
            Spacer(modifier = Modifier.height(16.dp))
            ConteudoAula(title = "Python", description = "dvfnjkdfnv skjfnkenfr vdkjfnk")
            Spacer(modifier = Modifier.height(16.dp))
            Slider(navController)
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .background(Color.White)
        ) {
            NavApp(navController)
        }
    }
}
@Preview
@Composable
fun ClassesPreview(){
    val navController = rememberNavController()
    Classes(navController)
}