package com.example.educationapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.Primary_Green
import com.example.educationapp.ui.theme.TextFieldBackground
import com.example.educationapp.ui.theme.TextFieldText

@Composable
fun CustomToggle(
    selectedOption: MutableState<String>,
    options: List<String> = listOf("Posts", "Photos")
) {
    val backgroundColor = TextFieldBackground
    val buttonColor = TextFieldText
    val textColor = Primary_Green
    val buttonPadding = 0.5.dp

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .padding(4.dp)
    ) {
        options.forEach { option ->
            Button(
                onClick = { selectedOption.value = option },
                modifier = Modifier
                    .weight(1f)
                    .padding(buttonPadding)
                    .background(
                        if (selectedOption.value == option) {
                            Color.White
                        } else backgroundColor,
                        shape = RoundedCornerShape(100.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text(
                    text = option,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = if (selectedOption.value == option) {
                        textColor
                    } else buttonColor
                )
            }
        }
    }
}