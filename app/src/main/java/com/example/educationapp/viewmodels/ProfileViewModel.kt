package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel() {
    private val _option = mutableStateOf("Posts")

    val option: MutableState<String> = _option

    fun setOption(option: String) {
        _option.value = option
    }
}