package com.example.jetpackcopmmposecomponent.Retrofit.util

import com.example.jetpackcopmmposecomponent.Retrofit.Post

sealed class ApiState {
    object Loading : ApiState()
    class Success(val data: List<Post>) : ApiState()
    class Failure(val msg: Throwable) : ApiState()

    object Empty : ApiState()
}