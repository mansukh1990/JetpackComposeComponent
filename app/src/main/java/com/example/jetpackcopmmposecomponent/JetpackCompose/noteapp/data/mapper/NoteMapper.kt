package com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.data.mapper

import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.data.local.entity.NoteEntity
import com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.domain.model.Note

fun NoteEntity.asExternalModel(): Note = Note(
    id, title, content
)

fun Note.toEntity(): NoteEntity = NoteEntity(
    id, title, content
)