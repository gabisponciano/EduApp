package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NavButtonModelView:ViewModel() {
    private val _selectedItemIndex = mutableStateOf<Int>(0)
    val selectedItemIndex: MutableState<Int> = _selectedItemIndex

    fun navUser(newNav:Int){
        _selectedItemIndex.value = newNav
    }
}