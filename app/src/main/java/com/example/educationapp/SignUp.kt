package com.example.educationapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
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
import androidx.compose.ui.draw.clip
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
import com.example.educationapp.components.HeaderSign
import com.example.educationapp.ui.theme.BackField
import com.example.educationapp.ui.theme.EducationAppTheme
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.Primary_Green
import com.example.educationapp.ui.theme.TextFieldBackground
import com.example.educationapp.ui.theme.TextFieldText
import com.example.educationapp.viewmodels.SignUpViewModel
import com.example.educationapp.viewmodels.UserViewModel

class SignUp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationAppTheme {
                val navController = rememberNavController()
                SignUp(navController = navController)
            }
        }
    }
}

@Composable
fun SignUp(navController: NavController){
    val signUpViewModel = viewModel<SignUpViewModel>()
    val context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),

        ){

        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState()),


            ){
            HeaderSign(text = "Sign Up", navController)

            OutlinedTextField(value = signUpViewModel.name.value,
                onValueChange = {signUpViewModel.nameUser(it)},
                label = { Text(text = ("Name"), color = TextFieldText) },
                singleLine = true,

                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = BackField,
                    unfocusedContainerColor = BackField,
                    focusedBorderColor = TextFieldBackground,
                    unfocusedBorderColor= TextFieldBackground
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.width(346.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(value = signUpViewModel.email.value,
                onValueChange = {signUpViewModel.emailUser(it)},
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

            OutlinedTextField(value = signUpViewModel.password.value,
                onValueChange = {signUpViewModel.passwordUser(it)},
                singleLine = true,
                label = { Text(text = "Password", color = TextFieldText) },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = BackField,
                    unfocusedContainerColor = BackField,
                    focusedBorderColor = TextFieldBackground,
                    unfocusedBorderColor= TextFieldBackground
                ),
                visualTransformation =
                if(signUpViewModel.showPassword.value){
                    VisualTransformation.None
                }else{
                    PasswordVisualTransformation()
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

                trailingIcon = {
                    if (signUpViewModel.showPassword.value){
                        Icon(
                            painterResource(R.drawable.visibility),
                            contentDescription = "",
                            modifier = Modifier.clickable { signUpViewModel.toggleShowPassword()  }
                        )
                    }
                    else{
                        Icon(
                            painterResource(R.drawable.novisibility),
                            contentDescription = "",
                            modifier = Modifier.clickable { signUpViewModel.toggleShowPassword() }
                        )
                    }
                },
                modifier = Modifier.width(346.dp)

            )
            Spacer(modifier = Modifier.height(32.dp))

            Row (verticalAlignment = Alignment.CenterVertically){
                Checkbox(checked = signUpViewModel.check.value,
                    onCheckedChange = {signUpViewModel.markCheck()},
                    colors = CheckboxDefaults.colors(checkmarkColor = Primary_Green)
                )
                Text(
                    text = "I would like to receive your newsletter and other promotional information",
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    fontFamily = Inter,

                    )

            }
            Spacer(modifier = Modifier.height(43.dp))

            Button(onClick = {
                if(signUpViewModel.email.value.isEmpty() || signUpViewModel.password.value.isEmpty() || signUpViewModel.name.value.isEmpty() ){
                    Toast.makeText(context, "It Has Empty Fields", Toast.LENGTH_LONG).show()
                }else{
                    navController.navigate("course")
                }

            },
                colors = ButtonDefaults.buttonColors(containerColor = Primary_Green),
                modifier = Modifier
                    .height(65.dp)
                    .width(343.dp),
            ) {
                Text(text = "Sign Up",
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
fun SignPreview(){
    val navController = rememberNavController()
    SignUp(navController)
}