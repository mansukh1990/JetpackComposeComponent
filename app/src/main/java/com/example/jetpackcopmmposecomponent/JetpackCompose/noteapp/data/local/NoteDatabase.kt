package com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.data.local.dao.NoteDao
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.data.local.entity.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {

    abstract val dao: NoteDao

    companion object {
        const val NAME = "note_db"
    }
}