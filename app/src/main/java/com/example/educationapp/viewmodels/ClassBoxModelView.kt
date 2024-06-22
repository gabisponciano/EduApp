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

    private val _check = mutableStateOf<Boolean>(false)
    val check: MutableState<Boolean> = _check

    //Faz a verificação se todas estão marcadas
    fun markAllCheck(boxes:List<CustomBox>){
        _allCheck.value = boxes.all {it.isChecked}
    }
    fun updateBoxCheck(box: CustomBox, isChecked: Boolean) {
        box.isChecked = isChecked
    }

    fun setChecked(value:Boolean){
        _check.value = value
    }

    fun markCheck(){
        _check.value = !_check.value
    }

}