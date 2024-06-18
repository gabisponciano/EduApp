package com.example.educationapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.educationapp.components.HeaderCourse
import com.example.educationapp.components.SearchBarUi
import com.example.educationapp.ui.theme.BackField

@Composable
fun Course(navController: NavController){
    var query by remember { mutableStateOf("") }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally){

        HeaderCourse(text = "Course" , navController)

        SearchBarUi(query = query,
            onQueryChange = {query = it},
            )
        Spacer(modifier = Modifier.height(16.dp))

        Content(title = "Java", description = "Pellentesque eget urna sit amet lacus rutrum placerat ac vel mi." )

        Spacer(modifier = Modifier.height(12.dp))

        Content(title = "Kotlin", description = "Pellentesque eget urna sit amet lacus rutrum placerat ac vel mi.")

        Spacer(modifier = Modifier.height(12.dp))

        Content(title = "Python", description = "Pellentesque eget urna sit amet lacus rutrum placerat ac vel mi.")

        Spacer(modifier = Modifier.height(12.dp))

        Content(title = "Go", description = "Pellentesque eget urna sit amet lacus rutrum placerat ac vel mi.")

        Box(modifier = Modifier
            .height(350.dp)
            .width(350.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(BackField)
        )

    }
}

@Preview
@Composable
fun CoursePreview(){
    val navController = rememberNavController()
    Course(navController)
}