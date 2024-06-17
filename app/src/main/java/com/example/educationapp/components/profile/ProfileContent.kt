package com.example.educationapp.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.educationapp.ui.theme.Inter
import com.example.educationapp.ui.theme.TextFieldBackground
import com.example.educationapp.viewmodels.ProfileViewModel

@Composable
fun ProfileContent(
    viewModel: ProfileViewModel,
    selectedOption: MutableState<String>
) {
    val contentList: List<String> = listOf("Header", "Body", "Footer", "Nav", "Section vs Article", "Tables")
    if (viewModel.option.value == "Photos") {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            contentList.forEach { contentText ->
                Box(
                    modifier = Modifier
                        .height(240.dp)
                        .width(343.dp)
                        .clip(RoundedCornerShape(4.dp   ))
                        .background(TextFieldBackground)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = contentText,
                    fontSize = 16.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(16.dp))
                Spacer(modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(TextFieldBackground))
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}