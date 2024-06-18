package com.example.educationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.G
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationapp.components.CustomToggle
import com.example.educationapp.ui.theme.EducationAppTheme
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.Primary_Green
import com.example.educationapp.ui.theme.TextFieldBackground
import com.example.educationapp.ui.theme.TextFieldText

class CongratulationsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EducationAppTheme {
                EducationAppLayout()
            }
        }
    }
}

@Composable
fun EducationAppLayout() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(Primary_Green)
    ) {
        Card(
            modifier = Modifier
                .width(343.dp)
                .height(363.dp)
                .shadow(elevation = 8.dp, clip = true, shape = RoundedCornerShape(8.dp))
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
            ) {
                Text(
                    text = "Parabéns!",
                    fontSize = 30.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Consequat velit qui adipisicing sunt do reprehenderit ad laborum tempor ullamco exercitation. Ullamco tempor adipisicing et voluptate duis sit esse aliqua esse ex dolore esse. Consequat velit qui adipisicing sunt.",
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary_Green,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "Certificado",
                        fontSize = 16.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Text(
                    text = "Voltar",
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary_Green,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { /*TODO*/ }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TipCalculatorPreview() {
    EducationAppTheme {
        EducationAppLayout()
    }
}