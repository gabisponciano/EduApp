package com.example.educationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationapp.components.CustomToggle
import com.example.educationapp.components.profile.ProfileContent
import com.example.educationapp.components.profile.ProfileCurso
import com.example.educationapp.components.profile.ProfilePhoto
import com.example.educationapp.ui.theme.EducationAppTheme
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.Primary_Green
import com.example.educationapp.ui.theme.TextFieldBackground

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationAppTheme {
                ProfileActivityLayout()
            }
        }
    }
}

@Composable
fun ProfileActivityLayout() {
    val selectedOption = remember { mutableStateOf("Posts") }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        topBar = {
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
                            .padding(horizontal = 16.dp, vertical = 16.dp)
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
                        Text(
                            text = "Logout",
                            fontSize = 16.sp,
                            color = Color.White,
                            fontFamily = Inter,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                    ProfilePhoto()
                }
            }
        },
        bottomBar = {
            BottomBar()
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp, top = 64.dp)
            ) {
                Text(
                    text = "Victoria Robertson",
                    fontSize = 30.sp,
                    color = Color.Black,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "A mantra goes here",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(28.dp))
            Column(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                CustomToggle(
                    options = listOf("Posts", "Photos"),
                    selectedOption = selectedOption.value,
                    onOptionSelect = { newOption ->
                        selectedOption.value = newOption
                    })
                Spacer(modifier = Modifier.height(8.dp))
                CursosContainer(selectedOption = selectedOption)
                ProfileContent(selectedOption = selectedOption)
            }
        }
    }
}

@Composable
fun BottomBar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color.White)
    ) {
        Spacer(modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(TextFieldBackground)
            .align(Alignment.TopStart))
        Row(
            horizontalArrangement = Arrangement.spacedBy(38.dp)
        ) {
            Box(modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(TextFieldBackground)
            )
            Box(modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(TextFieldBackground)
            )
            Box(modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(TextFieldBackground)
            )
            Box(modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(TextFieldBackground)
            )
            Box(modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(TextFieldBackground)
            )
        }
    }
}

@Composable
fun CursosContainer(
    selectedOption: MutableState<String>
) {
    if (selectedOption.value == "Posts") {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            ProfileCurso()
            ProfileCurso()
            ProfileCurso()
            ProfileCurso()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileActivityPreview() {
    EducationAppTheme {
        ProfileActivityLayout()
    }
}