package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpViewModel:ViewModel(){
    private val _email = mutableStateOf<String>("")
    private val _name = mutableStateOf<String>("")
    private val _password = mutableStateOf<String>("")
    private val _showPassword = mutableStateOf<Boolean>(false)
    private val _check = mutableStateOf<Boolean>(false)

    val email: MutableState<String> = _email
    val name: MutableState<String> = _name
    val password: MutableState<String> = _password
    val showPassword: MutableState<Boolean> = _showPassword
    val check: MutableState<Boolean> = _check

    fun emailUser(newEmail:String){
        _email.value = newEmail
    }

    fun nameUser(newName:String){
        _name.value = newName
    }

    fun passwordUser(newPassword: String){
        _password.value = newPassword
    }

    fun toggleShowPassword(){
        _showPassword.value = !_showPassword.value
    }

    fun setChecked(value:Boolean){
        _check.value = value
    }

    fun markCheck(){
        _check.value = !_check.value
    }




}