package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ClassBoxModelView: ViewModel() {
    private val _allCheck = mutableStateOf<Boolean>(false)


    val allCheck: MutableState<Boolean> = _allCheck

    fun markAllCheck(newAllMark:Boolean){
        _allCheck.value = !_allCheck.value
    }
}