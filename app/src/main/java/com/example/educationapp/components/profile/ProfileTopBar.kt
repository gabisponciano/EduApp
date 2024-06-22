package com.example.educationapp.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.Primary_Green
import com.example.educationapp.viewmodels.ProfileViewModel

@Composable
fun ProfileTopBar(viewModel: ProfileViewModel, navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(245.dp)
            .background(Primary_Green)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            ) {
                Text(
                    text = "Settings",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = "Profile",
                    fontSize = 30.sp,
                    color = Color.White,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )
                Button(
                    onClick = { viewModel.setModalVisibility(true)},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent
                    )
                ) {
                    Text(
                        text = "Logout",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontFamily = Inter,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
            ProfilePhoto()
        }
    }
}
