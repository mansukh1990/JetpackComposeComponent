package com.example.jetpackcopmmposecomponent.JetpackCompose.noteapp.presentation.screen.note

sealed interface NoteEvent {

    data class TitleChange(val title: String) : NoteEvent
    data class ContentChange(val content: String) : NoteEvent
    object SaveNote : NoteEvent
    object NavigateBack : NoteEvent
    object DeleteNote : NoteEvent

}