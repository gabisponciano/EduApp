package com.example.educationapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationapp.ui.theme.BackField
import com.example.educationapp.ui.theme.Inter

@Composable
fun Content(
    title: String,
    description: String,
    boxSizeW: Dp = 50.dp,
    boxSizeH: Dp =50.dp,
    cornerRadius: Dp = 10.dp,
    spacing: Dp = 28.dp,
    rowWidth: Dp = 320.dp,
){
    Column (){
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(spacing)
        ) {
            Box(
                modifier = Modifier
                    .width(boxSizeW)
                    .height(boxSizeH)
                    .clip(RoundedCornerShape(cornerRadius))
                    .background(BackField),
                contentAlignment = Alignment.TopCenter
            ) {
                // You can add content inside this Box if needed
            }
            Box(
                modifier = Modifier
                    .height(90.dp)
                    .width(220.dp)
            ) {
                Column {
                    Text(title, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, fontFamily = Inter)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        description,
                        fontSize = 14.sp,
                        fontFamily = Inter
                    )
                }
            }
        }
        Divider(color = BackField, thickness = 1.dp, modifier = Modifier.width(277.dp))
    }

}