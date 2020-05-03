package com.example.higuuugithubapi.api

import com.example.higuuugithubapi.data.UserRepoResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface ClientApi {
    @GET("users/{userName}/repos")
    fun getUserRepos(@Path("userName") userName: String): Single<Response<List<UserRepoResponse>>>
}
