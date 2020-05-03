package com.example.higuuugithubapi.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.higuuugithubapi.ClientApiRepository
import com.example.higuuugithubapi.main.MainViewModel
import javax.inject.Inject

class MainViewModelFactory @Inject constructor(private val clientApiRepository: ClientApiRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(clientApiRepository) as T
    }
}