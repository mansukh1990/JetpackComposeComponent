package com.example.jetpackcopmmposecomponent.ToDoApp.repository

import com.example.jetpackcopmmposecomponent.ToDoApp.RoomDataBase.ToDo
import com.example.jetpackcopmmposecomponent.ToDoApp.RoomDataBase.ToDoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private val dao: ToDoDao
) {

    suspend fun insert(toDo: ToDo) = withContext(Dispatchers.IO) {
        dao.insert(toDo)
    }

    fun getAllToDos(): Flow<List<ToDo>> = dao.getAllToDos()
}