package com.sample.samplebase.data.repository

import com.sample.samplebase.data.model.TestModel
import com.sample.samplebase.data.remote.ApiService
import retrofit2.Call

class TestRepository(private val apiService: ApiService){
    fun getData() : Call<TestModel> =
        apiService.getAllSharedPostAsync()
}