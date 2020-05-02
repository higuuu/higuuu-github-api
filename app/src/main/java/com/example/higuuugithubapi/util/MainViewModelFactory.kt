package com.example.higuuugithubapi.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.higuuugithubapi.ClientApiRepository
import com.example.higuuugithubapi.MainViewModel

class MainViewModelFactory(private val clientApiRepository: ClientApiRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(clientApiRepository) as T
    }
}