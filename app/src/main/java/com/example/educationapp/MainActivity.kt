package com.example.educationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.educationapp.ui.theme.EducationAppTheme
import com.example.educationapp.viewmodels.ProfileViewModel
import com.example.educationapp.viewmodels.SupportViewModel
import com.example.educationapp.viewmodels.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login"){
                    composable("login"){
                        LogIn(navController)
                    }
                    composable("signup"){
                        SignUp(navController)
                    }
                    composable("course"){
                        Course(navController)
                    }
                    composable("classes"){
                        Classes(navController)
                    }
                    composable("certificate"){
                        EducationAppLayout(navController)
                    }
                    composable("profile"){
                        ProfileActivityLayout(viewModel = ProfileViewModel(), navController)
                    }
                    composable("support"){
                        SupportActivityLayout(viewModel = SupportViewModel(), navController)
                    }

                }
            }

        }
    }
}