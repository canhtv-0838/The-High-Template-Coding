package com.sample.samplebase

import android.util.Log
import androidx.lifecycle.ViewModel
import com.sample.samplebase.data.model.TestModel
import com.sample.samplebase.data.repository.TestRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TestViewModel(private val repo : TestRepository) : ViewModel(){

    fun getData(){
        repo.getData().enqueue(object : Callback<TestModel> {
            override fun onFailure(call: Call<TestModel>, t: Throwable) {
                Log.d("canh123", "${t.toString()}")

            }

            override fun onResponse(call: Call<TestModel>, response: Response<TestModel>) {
                Log.d("canh123", "${response.body()}")
            }
        })

    }
}