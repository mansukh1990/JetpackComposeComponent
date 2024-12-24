package com.example.jetpackcopmmposecomponent.ToDoApp.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcopmmposecomponent.ToDoApp.RoomDataBase.ToDo
import com.example.jetpackcopmmposecomponent.ToDoApp.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel() {

    val response: MutableState<List<ToDo>> = mutableStateOf(listOf())

    fun insert(toDo: ToDo) = viewModelScope.launch {
        toDoRepository.insert(toDo)
    }

    init {
        getAllToDos()
    }

    private fun getAllToDos() = viewModelScope.launch {
        toDoRepository.getAllToDos()
            .catch { e ->
                Log.e("main", "Exception: ${e.message}")

            }.collect {
                response.value = it

            }
    }
}