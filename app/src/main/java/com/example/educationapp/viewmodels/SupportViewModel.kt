package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SupportViewModel : ViewModel() {
    private val _messageList = mutableStateListOf<String>(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
    )
    private val _messageStateFlow = MutableStateFlow(_messageList)
    val messageList: StateFlow<List<String>> = _messageStateFlow.asStateFlow()

    fun addMessage(message: String) {
        _messageList.add(message)
        _messageStateFlow.value = _messageList
    }
}

