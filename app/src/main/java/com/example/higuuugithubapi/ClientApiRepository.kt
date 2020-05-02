package com.example.higuuugithubapi

import com.example.higuuugithubapi.api.ClientApi
import com.example.higuuugithubapi.data.UserRepoRequest
import com.example.higuuugithubapi.data.UserRepoResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ClientApiRepository constructor(val clientApi: ClientApi){

    fun getUser(userRepoRequest:String): Single<List<UserRepoResponse>> {
        return clientApi.getUserRepos(userRepoRequest)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                val body = it.body()
                    ?: throw HttpException(it)
                return@map body
            }
    }

}