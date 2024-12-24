package com.example.jetpackcopmmposecomponent.Retrofit

import com.example.jetpackcopmmposecomponent.Retrofit.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getPosts(): Flow<List<Post>> = flow {
        emit(apiService.getPosts())
    }.flowOn(Dispatchers.IO)
}