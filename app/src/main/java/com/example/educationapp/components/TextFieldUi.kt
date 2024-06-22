package com.example.educationapp.components

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.educationapp.ui.theme.BackField
import com.example.educationapp.ui.theme.TextFieldBackground
import com.example.educationapp.ui.theme.TextFieldText

@Composable
fun TextFieldUi(value:String, onValueChange:(String) -> Unit){
    OutlinedTextField(value = value,
        onValueChange = {onValueChange(it)},
        label = { Text(text = (""), color = TextFieldText) },
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = BackField,
            unfocusedContainerColor = BackField,
            focusedBorderColor = TextFieldBackground,
            unfocusedBorderColor= TextFieldBackground
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier.width(346.dp)

    )
}
@Preview
@Composable
fun TextFieldPreview()
{
    TextFieldUi(value = "") {

    }
}