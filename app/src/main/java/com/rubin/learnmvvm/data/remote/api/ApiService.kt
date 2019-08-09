package com.rubin.learnmvvm.data.remote.api

import com.rubin.learnmvvm.data.remote.domain.Post
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    fun getPosts(): Single<List<Post>>
}