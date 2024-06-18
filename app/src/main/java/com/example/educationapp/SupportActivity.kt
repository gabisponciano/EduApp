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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationapp.ui.theme.DarkerGray
import com.example.educationapp.ui.theme.EducationAppTheme
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.Primary_Green
import com.example.educationapp.ui.theme.TextFieldBackground
import com.example.educationapp.ui.theme.TextFieldText

class SupportActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EducationAppTheme {
                SupportActivityLayout()
            }
        }
    }
}

@Composable
fun SupportActivityLayout() {
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
                    .padding(16.dp)
            ) {
                Text(
                    text = "Back",
                    fontSize = 16.sp,
                    color = Primary_Green,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium
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
            BottomInputBar()
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        )  {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp)
            ) {
                Spacer(modifier = Modifier.height(12.dp))
                Spacer(modifier = Modifier.height(1.dp).fillMaxWidth().background(DarkerGray))
            }
        }
    }
}

@Composable
fun BottomInputBar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {/*TODO*/},
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
                        tint = Color.White
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
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SupportActivityPreview() {
    EducationAppTheme {
        SupportActivityLayout()
    }
}