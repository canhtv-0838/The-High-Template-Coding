package com.sample.samplebase.data.remote

import com.sample.samplebase.BuildConfig
import com.sample.samplebase.data.model.TestModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit

interface ApiService {
    @GET("get_all_shared_post.php")
    fun getAllSharedPostAsync(): Call<TestModel>

    companion object {
        private const val TIMEOUT = 10L
        private const val BASE_URL = "https://trvcanh197.000webhostapp.com/moviedb/"

        fun createHeaderInterceptor(): Interceptor =
            Interceptor { chain ->
                val request = chain.request().newBuilder()
//            .addHeader("app-ver", BuildConfig.VERSION_NAME)
//            .addHeader("app-os", "android")
                    .build()
                chain.proceed(request)
            }

        fun createLoggingInterceptor(): Interceptor =
            HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            }

        fun createOkHttpClient(

        ): OkHttpClient =
            OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(createHeaderInterceptor())
                .addInterceptor(createLoggingInterceptor())
                .build()

        fun createRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }
}
