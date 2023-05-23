package com.example.bancomlogin.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {
    var email by mutableStateOf(""); private set
    var password by mutableStateOf(""); private set
    var isShowPassword by mutableStateOf(false); private set
    var isCheckedRememberEmail by mutableStateOf(false); private set

    fun onEmailChanged(text: String) {
        viewModelScope.launch {
            email = text
        }
    }

    fun onPasswordChanged(text: String) {
        viewModelScope.launch {
            password = text
        }
    }

    fun onShowPasswordChanged(onShow: Boolean) {
        viewModelScope.launch {
            isShowPassword = onShow
        }
    }

    fun onCheckedRememberChanged(onChecked: Boolean) {
        viewModelScope.launch {
            isCheckedRememberEmail = onChecked
        }
    }
}