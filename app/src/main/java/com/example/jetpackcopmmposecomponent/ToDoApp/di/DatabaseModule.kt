package com.example.jetpackcopmmposecomponent.ToDoApp.di

import android.app.Application
import androidx.room.Room
import com.example.jetpackcopmmposecomponent.ToDoApp.RoomDataBase.ToDoDao
import com.example.jetpackcopmmposecomponent.ToDoApp.RoomDataBase.ToDoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(application: Application): ToDoDatabase =
        Room.databaseBuilder(application, ToDoDatabase::class.java, "ToDoDatabase")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesDao(db: ToDoDatabase): ToDoDao = db.getDao()
}