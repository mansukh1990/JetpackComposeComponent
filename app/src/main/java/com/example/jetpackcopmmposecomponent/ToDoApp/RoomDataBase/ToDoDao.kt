package com.example.jetpackcopmmposecomponent.ToDoApp.RoomDataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(toDo: ToDo)

    @Query("SELECT * FROM  todo_table")
    fun getAllToDos(): Flow<List<ToDo>>
}