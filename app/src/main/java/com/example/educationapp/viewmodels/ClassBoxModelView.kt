package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educationapp.components.CustomBox

class ClassBoxModelView: ViewModel() {
    private val _allCheck = mutableStateOf<Boolean>(false)

    val allChecked: MutableState<Boolean> = _allCheck

    fun markAllCheck(boxes:List<CustomBox>){
        _allCheck.value = boxes.all {it.isChecked}
    }
    fun updateBoxCheck(box: CustomBox, isChecked: Boolean) {
        box.isChecked = isChecked
    }
}