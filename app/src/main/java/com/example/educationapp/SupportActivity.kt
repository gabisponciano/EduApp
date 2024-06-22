package com.example.educationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.educationapp.ui.theme.DarkerGray
import com.example.educationapp.ui.theme.EducationAppTheme
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.Primary_Green
import com.example.educationapp.ui.theme.TextFieldBackground
import com.example.educationapp.ui.theme.TextFieldText
import com.example.educationapp.viewmodels.SupportViewModel

class SupportActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationAppTheme {
                val viewModel: SupportViewModel by viewModels()
                SupportActivityLayout(viewModel, navController = rememberNavController())
            }
        }
    }
}

@Composable
fun SupportActivityLayout(
    viewModel: SupportViewModel,
    navController: NavController
) {
    var messageInput by remember { mutableStateOf("") }
    val messageList by viewModel.messageList.collectAsState()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding(),
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 24.dp)
            ) {
                Text(
                    text = "Back",
                    fontSize = 16.sp,
                    color = Primary_Green,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable { navController.popBackStack() }
                )
                Text(
                    text = "Profile",
                    fontSize = 30.sp,
                    color = Color.Black,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "Filter",
                    fontSize = 16.sp,
                    color = Primary_Green,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                )
            }
        },
        bottomBar = {
            BottomInputBar(
                messageInput = messageInput,
                onMessageInputChange = { newInput -> messageInput = newInput },
                onDone = {
                    viewModel.addMessage(messageInput)
                    messageInput = ""
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        )  {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .width(235.dp)
                        .clip(
                            RoundedCornerShape(
                                topStart = 10.dp,
                                topEnd = 10.dp,
                                bottomStart = 10.dp
                            )
                        )
                        .background(TextFieldBackground)
                        .padding(vertical = 20.dp, horizontal = 16.dp)
                        .align(Alignment.Start)
                ) {
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectuter adipiscing elit. Donec fringilla quam eu faci lisis mollis.",
                        fontSize = 14.sp,
                        color = Color.Black,
                        fontFamily = Inter,
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                messageList.forEach { message ->
                    Box(
                        modifier = Modifier
                            .width(235.dp)
                            .clip(
                                RoundedCornerShape(
                                    topStart = 10.dp,
                                    topEnd = 10.dp,
                                    bottomStart = 10.dp
                                )
                            )
                            .background(Primary_Green)
                            .padding(vertical = 20.dp, horizontal = 16.dp)
                            .align(Alignment.End)
                    ) {
                        Text(
                            text = message,
                            fontSize = 14.sp,
                            color = Color.White,
                            fontFamily = Inter,
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}

@Composable
fun BottomInputBar(
    messageInput: String,
    onMessageInputChange: (String) -> Unit,
    onDone: () -> Unit,
) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = messageInput,
            onValueChange = { onMessageInputChange(it) },
            trailingIcon = {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .background(Primary_Green)
                        .height(34.dp)
                        .aspectRatio(1f)
                ) {
                    Icon(
                        painterResource(id = R.drawable.baseline_arrow_upward_24),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.clickable { onDone() }
                    )
                }
            },
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = TextFieldBackground,
                unfocusedContainerColor = TextFieldBackground,
                unfocusedBorderColor = DarkerGray,
                focusedBorderColor = DarkerGray
            ),
            placeholder = {
                Text(
                    text = "Message here...",
                    fontSize = 16.sp,
                    color = TextFieldText,
                    fontWeight = FontWeight.Medium
                )
            },
            keyboardActions = KeyboardActions(onDone = { onDone() }),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SupportActivityPreview() {
    EducationAppTheme {
        SupportActivityLayout(viewModel = SupportViewModel(), navController = rememberNavController())
    }
}