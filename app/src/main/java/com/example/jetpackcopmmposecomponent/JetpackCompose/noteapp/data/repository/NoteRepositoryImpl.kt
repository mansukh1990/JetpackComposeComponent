package com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.data.repository

import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.data.local.dao.NoteDao
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.data.mapper.asExternalModel
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.data.mapper.toEntity
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.domain.model.Note
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> {
        return dao.getAllNotes()
            .map { notes ->
                notes.map {
                    it.asExternalModel()
                }

            }
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)?.asExternalModel()
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note.toEntity())
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note.toEntity())
    }

    override suspend fun updateNote(note: Note) {
        dao.updateNote(note.toEntity())
    }
}