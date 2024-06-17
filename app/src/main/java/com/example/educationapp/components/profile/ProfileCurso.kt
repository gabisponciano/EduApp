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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.TextFieldBackground
import com.example.educationapp.ui.theme.TextFieldText

@Composable
fun ProfileCurso() {
    Spacer(modifier = Modifier.height(16.dp))
    Row(
    ) {
        Box(
            modifier = Modifier
                .width(50.dp)
                .height(50.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(TextFieldBackground)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Curso",
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "8m ago",
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    color = TextFieldText
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "He'll want to use your yacht, and I don't want this thing smelling like fish.")
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(TextFieldBackground)
            )
        }
    }
}