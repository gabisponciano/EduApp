package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class userviewmodel:ViewModel(){
    private val _email = mutableStateOf<String>("")
    val email: MutableState<String> = _email
    private val _password  = mutableStateOf<String>("")
    val password: MutableState<String> = _password
    fun emailUser(newEmail:String){
        _email.value = newEmail
    }

    fun password(nemPassword:String){
        _password.value = nemPassword
    }
}