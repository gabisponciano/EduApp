package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class UserViewModel:ViewModel(){
    private val _email = mutableStateOf<String>("")
    val email: MutableState<String> = _email

    private val _password  = mutableStateOf<String>("")
    val password: MutableState<String> = _password

    private val _showPassword = mutableStateOf<Boolean>(false)
    val showPassword: MutableState<Boolean> = _showPassword
    fun emailUser(newEmail:String){
        _email.value = newEmail
    }

    fun passwordUser(newPassword:String){
        _password.value = newPassword
    }

    fun toggleShowPassword(){
        _showPassword.value = !_showPassword.value
    }
}