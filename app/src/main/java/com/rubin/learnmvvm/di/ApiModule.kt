package com.rubin.learnmvvm.di

import com.rubin.learnmvvm.data.remote.api.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single { get<Retrofit>().create(ApiService::class.java) }
}