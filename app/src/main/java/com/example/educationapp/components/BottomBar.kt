package com.example.educationapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationapp.ui.theme.TextFieldBackground

@Composable
fun BottomBar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
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
                .height(35.dp)
                .width(35.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(TextFieldBackground)
            )
            Box(modifier = Modifier
                .height(35.dp)
                .width(35.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(TextFieldBackground)
            )
            Box(modifier = Modifier
                .height(35.dp)
                .width(35.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(TextFieldBackground)
            )
            Box(modifier = Modifier
                .height(35.dp)
                .width(35.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(TextFieldBackground)
            )
            Box(modifier = Modifier
                .height(35.dp)
                .width(35.dp)
                .clip(RoundedCornerShape(50.dp))
                .background(TextFieldBackground)
            )
        }
    }
}
@Preview
@Composable
fun BottomPreview(){
    BottomBar()
}