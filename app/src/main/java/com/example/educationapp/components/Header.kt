package com.example.educationapp.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.educationapp.R
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.Primary_Green

@Composable
fun HeaderLog(text:String ){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        contentAlignment = Alignment.Center

    )
    {
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text, fontSize =30.sp, fontFamily = Inter, fontWeight = FontWeight.SemiBold)

            }

        }
    }
}

@Composable
fun HeaderSign(text: String, navController: NavController){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        contentAlignment = Alignment.Center


    )
    {
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text, fontSize =30.sp, fontFamily = Inter, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.width(56.dp))
                Text(text = "Login",
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary_Green,
                    modifier = Modifier.clickable {
                        navController.navigate("login")
                    })

            }

        }
    }
}

@Composable
fun HeaderCourse(text: String, navController: NavController, title: String){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
        contentAlignment = Alignment.Center


    )
    {
        Column (horizontalAlignment = Alignment.CenterHorizontally){
            Row(verticalAlignment = Alignment.CenterVertically){
                Text(text = title,
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary_Green,
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(56.dp))
                Text(text, fontSize =30.sp, fontFamily = Inter, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.width(56.dp))
                Text(text = "Filter",
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary_Green,
                    modifier = Modifier.clickable {
                        navController.navigate("")
                    })



            }

        }
    }
}



@Preview
@Composable
fun HeaderPreview(){
    //HeaderSign("Sign Up",)
}