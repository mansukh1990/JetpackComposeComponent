package com.example.jetpackcopmmposecomponent.component.statemanagement

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StateViewModel @Inject constructor() : ViewModel() {

    val name: MutableState<String> = mutableStateOf("mansukh")
}