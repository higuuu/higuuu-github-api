package com.example.higuuugithubapi.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.higuuugithubapi.ClientApiRepository
import com.example.higuuugithubapi.data.UserRepoResponse
import javax.inject.Inject

class MainViewModel @Inject constructor(val clientApiRepository: ClientApiRepository) : ViewModel() {
    private val _userRepos: MutableLiveData<List<UserRepoResponse>> = MutableLiveData()
    val userRepos: LiveData<List<UserRepoResponse>> = _userRepos

    fun getUser(userRepoRequest: String) {
        clientApiRepository.getUser(userRepoRequest)
            .subscribe { response: List<UserRepoResponse>? ->
                _userRepos.postValue(response)
            }
    }
}