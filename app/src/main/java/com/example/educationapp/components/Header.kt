package com.example.educationapp.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HeaderLog(text:String){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        contentAlignment = Alignment.Center

    )
    {
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text, fontSize =30.sp, fontWeight = FontWeight.Bold,)
            }

        }
    }
}

@Preview
@Composable
fun HeaderPreview(){
    HeaderLog(text = "Course")
}