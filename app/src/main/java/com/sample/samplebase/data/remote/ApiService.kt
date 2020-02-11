package com.sample.samplebase.data.remote

import com.sample.samplebase.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface ApiService {
    companion object {
        private const val TIMEOUT = 10L
        private const val BASE_URL = "https://api.themoviedb.org/3/"

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
            logging: Interceptor,
            header: Interceptor
        ): OkHttpClient =
            OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(header)
                .addInterceptor(logging)
                .build()

        fun createRetrofit(okHttpClient: OkHttpClient) {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

    }
}
