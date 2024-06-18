package com.example.educationapp.components.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.educationapp.R

@Composable
fun ProfilePhoto() {
    val offset = with(LocalDensity.current) {
        (158.dp / 8 ).toPx()
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .offset(y = offset.dp)
            .clip(RoundedCornerShape(200.dp))
            .width(158.dp)
            .height(158.dp)
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_photo),
            contentDescription = "Your profile photo",
            modifier = Modifier
                .clip(RoundedCornerShape(200.dp))
                .height(150.dp)
                .width(150.dp)
        )
    }
}