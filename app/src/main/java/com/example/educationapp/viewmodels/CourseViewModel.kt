package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CourseViewModel:ViewModel() {
    private val _query = mutableStateOf<String>("")
    val query: MutableState<String> = _query

    fun queryUser(newQuery:String){
        _query.value = newQuery
    }

}