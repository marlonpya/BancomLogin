package com.example.bancomlogin.home

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.bancomlogin.DispatcherProvider
import com.example.bancomlogin.domain.CustomResult
import com.example.bancomlogin.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCase: GetUsersUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    val users = mutableStateListOf<UserModel>()
    var loading by mutableStateOf("loading")

    fun callUsers() {
        GlobalScope.launch(dispatcherProvider.IO + dispatcherProvider.coroutineExceptionHandler { _, ex ->
            loading = "loading"
        }) {
            when (val result = useCase.execute()) {
                is CustomResult.OnSuccess -> {
                    val list = result.data.map {
                        UserModel(
                            it.name,
                            it.userName,
                            it.address,
                            it.email,
                            it.phoneNumber
                        )
                    }
                    loading = ""
                    users.addAll(list)
                }
                is CustomResult.OnError -> {
                    loading = result.error.message ?: ""
                }
            }
        }
    }

}