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
    private val badWords: Set<String> = setOf("caralho", "porra", "krl", "bct", "buceta", "fdp", "puta")

    val messageList: StateFlow<List<String>> = _messageStateFlow.asStateFlow()

    fun addMessage(message: String) {
        val filteredMessage = message.split(" ")
            .map { word ->
                if (badWords.contains(word.lowercase())) {
                    "*".repeat(word.length)
                } else {
                    word
                }
            }.joinToString(" ")
        if (filteredMessage.isNotEmpty()) {
            _messageList.add(filteredMessage)
            _messageStateFlow.value = _messageList
        }
    }
}

