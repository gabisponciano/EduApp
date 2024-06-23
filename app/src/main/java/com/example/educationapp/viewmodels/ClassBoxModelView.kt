package com.example.educationapp.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educationapp.components.CustomBox

class ClassBoxModelView: ViewModel() {
    private val _allCheck = mutableStateOf<Boolean>(false)
    val allChecked: MutableState<Boolean> = _allCheck

    //Lista de Box
    private val _customBoxes = mutableStateListOf(
        CustomBox("Python 01", "Introduction"),
        CustomBox("Python 02", "OOP"),
        CustomBox("Python 03", "First Project")
    )
    val customBoxes: List<CustomBox> get()= _customBoxes


    //Faz a verificação se todas estão marcadas
    fun markAllCheck(){
        _allCheck.value =_customBoxes.all {it.isChecked}
    }
    // Atualiza o estado de uma box da lista
    fun updateBoxCheck(box: CustomBox, isChecked: Boolean) {
        val index = _customBoxes.indexOf(box)
        if (index != -1) {
            _customBoxes[index] = box.copy(isChecked = isChecked)
            markAllCheck()
        }
    }
}