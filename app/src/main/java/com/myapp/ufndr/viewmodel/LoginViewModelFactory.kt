package com.myapp.ufndr.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myapp.ufndr.ui.interfaces.LogInResultCallback

class LoginViewModelFactory(private val listener:LogInResultCallback): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LogInViewModel(listener) as T
    }
}