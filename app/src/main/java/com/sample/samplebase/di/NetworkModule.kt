package com.sample.samplebase.di

import com.sample.samplebase.data.remote.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {
//    single { ApiService.createHeaderInterceptor() }
//    single { ApiService.createLoggingInterceptor() }
//    single { ApiService.createOkHttpClient(get(), get()) }
    single { ApiService.createRetrofit() }
    single { createApiService<ApiService>(get()) }
}

inline fun <reified T> createApiService(retrofit: Retrofit): T =
    retrofit.create(T::class.java)
