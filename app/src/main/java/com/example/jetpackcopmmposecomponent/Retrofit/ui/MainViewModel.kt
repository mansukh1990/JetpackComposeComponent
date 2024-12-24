package com.example.jetpackcopmmposecomponent.Retrofit.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcopmmposecomponent.Retrofit.MainRepository
import com.example.jetpackcopmmposecomponent.Retrofit.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    val response: MutableState<ApiState> = mutableStateOf(ApiState.Empty)

    init {
        getPosts()
    }

    fun getPosts() = viewModelScope.launch {
        mainRepository.getPosts()
            .onStart {
                response.value = ApiState.Loading

            }.catch {
                response.value = ApiState.Failure(msg = it)

            }.collect {
                response.value = ApiState.Success(data = it)
            }
    }
}