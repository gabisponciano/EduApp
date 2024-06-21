package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel() {
    private val _option = mutableStateOf("Posts")
    val option: MutableState<String> = _option

    private val _showModal = mutableStateOf(false)
    val showModal: MutableState<Boolean> = _showModal

    private val _showBox = mutableStateOf(false)
    val showBox: MutableState<Boolean> = _showBox

    fun setOption(option: String) {
        _option.value = option
    }

    fun setModalVisibility(visible: Boolean) {
        _showModal.value = visible
    }

    fun setBoxVisibility(visible: Boolean) {
        _showBox.value = visible
    }
}