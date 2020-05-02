package com.example.higuuugithubapi.util

import com.example.higuuugithubapi.ClientApiRepository
import com.example.higuuugithubapi.api.ClientApi

object RepositoryFactory {
    fun createClientApiRepository(): ClientApiRepository{
        val clientApi = RestUtil.retrofit.create(ClientApi::class.java)
        return ClientApiRepository(clientApi)
    }
}