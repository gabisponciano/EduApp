package com.example.educationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationapp.components.CustomToggle
import com.example.educationapp.components.profile.ProfileContent
import com.example.educationapp.components.profile.ProfileCurso
import com.example.educationapp.components.profile.ProfilePhoto
import com.example.educationapp.components.profile.ProfileTopBar
import com.example.educationapp.ui.theme.EducationAppTheme
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.Primary_Green
import com.example.educationapp.ui.theme.TextFieldBackground
import com.example.educationapp.viewmodels.ProfileViewModel
import kotlinx.coroutines.delay

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationAppTheme {
                val viewModel: ProfileViewModel by viewModels()
                ProfileActivityLayout(viewModel)
            }
        }
    }
}

@Composable
fun ProfileActivityLayout(viewModel: ProfileViewModel) {
    val selectedOption = remember { mutableStateOf("Posts") }
    Box(modifier = Modifier) {

        Column(modifier = Modifier) {
            ProfileTopBar(viewModel = viewModel)
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
                    viewModel = viewModel,
                    options = listOf("Posts", "Photos"),
                    onOptionSelect = { newOption ->
                        viewModel.setOption(newOption)
                    })
                Spacer(modifier = Modifier.height(8.dp))
                CursosContainer(viewModel = viewModel, selectedOption = selectedOption)
                ProfileContent(viewModel = viewModel, selectedOption = selectedOption)
            }
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomBar()
        }
        val density = LocalDensity.current

        AnimatedVisibility(
            visible = viewModel.showModal.value,
            enter = slideInVertically{
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(expandFrom = Alignment.Top),
            exit = slideOutVertically {
                with(density) { -40.dp.roundToPx() }
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.5f)
                    .background(Color.Black)
                    .clickable {
                        viewModel.setModalVisibility(false); viewModel.setBoxVisibility(
                        false
                    )
                    }
            )
        }

        LaunchedEffect(key1 = viewModel.showModal.value) {
            if (viewModel.showModal.value) {
                delay(400)
                viewModel.setBoxVisibility(true)
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(
                visible = viewModel.showBox.value,
                enter = slideInVertically {
                    with(density) { 40.dp.roundToPx() }
                } + expandVertically(expandFrom = Alignment.Bottom),
                exit = slideOutVertically {
                    with(density) { 40.dp.roundToPx() }
                },
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(360.dp)) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.padding(top = 32.dp, bottom = 32.dp, start = 16.dp, end = 16.dp).fillMaxHeight()
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            Text(
                                text = "Logout",
                                fontSize = 30.sp,
                                fontFamily = Inter,
                                fontWeight = FontWeight.Medium,
                            )
                            Text(
                                text = "Tem certeza que quer sair? Qualquer coisa estaremos aqui para te ajudar no que for preciso.",
                                fontSize = 16.sp,
                                fontFamily = Inter,
                                fontWeight = FontWeight.Normal,
                                textAlign = TextAlign.Center
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                onClick = { /*TODO*/},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Primary_Green,
                                    contentColor = Color.White
                                ),
                                modifier = Modifier.fillMaxWidth().height(58.dp)
                            ) {
                                Text(
                                    text = "Logout",
                                    fontSize = 16.sp,
                                    fontFamily = Inter,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Button(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.Transparent,
                                    contentColor = Primary_Green
                                )
                            ) {
                                Text(
                                    text = "Cancelar",
                                    fontSize = 16.sp,
                                    fontFamily = Inter,
                                    fontWeight = FontWeight.Medium,
                                    color = Primary_Green
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
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
    viewModel: ProfileViewModel,
    selectedOption: MutableState<String>
) {
    if (viewModel.option.value == "Posts") {
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
        ProfileActivityLayout(viewModel = ProfileViewModel())
    }
}