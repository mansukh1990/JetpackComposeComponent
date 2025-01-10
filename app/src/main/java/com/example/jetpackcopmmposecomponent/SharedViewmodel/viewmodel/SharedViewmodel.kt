package com.example.jetpackcopmmposecomponent.SharedViewmodel.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SharedViewmodel : ViewModel() {

    private val _res: MutableState<String> = mutableStateOf("")
    val res: State<String> = _res

    fun setData(data: String) {
        _res.value = data

    }
}