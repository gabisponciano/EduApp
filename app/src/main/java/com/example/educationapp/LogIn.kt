package com.example.educationapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.educationapp.components.HeaderLog
import com.example.educationapp.ui.theme.BackField
import com.example.educationapp.ui.theme.EducationAppTheme
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.Primary_Green
import com.example.educationapp.ui.theme.TextFieldBackground
import com.example.educationapp.ui.theme.TextFieldText
import com.example.educationapp.viewmodels.UserViewModel

class LogIn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationAppTheme {
                val navController = rememberNavController()
                LogIn(navController = navController)

            }
        }
    }
}

@Composable
fun LogIn(navController: NavController){

    val userViewModel = viewModel<UserViewModel>()
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
    ){

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){
            HeaderLog(text = "Log In",navController)

            OutlinedTextField(value = userViewModel.email.value,
                onValueChange = { userViewModel.emailUser(it)},
                label = { Text(text = ("Email"), color = TextFieldText) },
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = BackField,
                    unfocusedContainerColor = BackField,
                    focusedBorderColor = TextFieldBackground,
                    unfocusedBorderColor= TextFieldBackground
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.width(346.dp)

            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value = userViewModel.password.value,
                onValueChange = {userViewModel.passwordUser(it)},
                singleLine = true,
                label = { Text(text = "Password", color = TextFieldText)},
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = BackField,
                    unfocusedContainerColor = BackField,
                    focusedBorderColor = TextFieldBackground,
                    unfocusedBorderColor= TextFieldBackground
                ),
                visualTransformation =
                if(userViewModel.showPassword.value){
                    VisualTransformation.None
                }else{
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                trailingIcon = {
                    if (userViewModel.showPassword.value){
                        Icon(
                            painterResource(R.drawable.visibility),
                            contentDescription = "",
                            modifier = Modifier.clickable { userViewModel.toggleShowPassword()  }
                        )
                    }
                    else{
                        Icon(painterResource(R.drawable.novisibility),
                            contentDescription = "",
                            modifier = Modifier.clickable { userViewModel.toggleShowPassword() }
                        )
                    }
                },
                modifier = Modifier.width(346.dp)
            )
            Spacer(modifier = Modifier.height(43.dp))
            Button(onClick = {
                if(userViewModel.email.value.isEmpty() || userViewModel.password.value.isEmpty() ){
                    Toast.makeText(context, "It Has Empty Fields",Toast.LENGTH_LONG).show()
                }else{
                    navController.navigate("course")
                }


            },
                colors = ButtonDefaults.buttonColors(containerColor = Primary_Green),
                modifier = Modifier
                    .height(65.dp)
                    .width(343.dp),
            ) {
                Text(text = "Log In",
                    fontSize = 18.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium)


            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Forgot your password?",
                fontSize = 16.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.SemiBold,
                color = Primary_Green

            )

        }

    }

}

@Preview
@Composable
fun LogInPreview(){
    val navController = rememberNavController()
    LogIn(navController)
}