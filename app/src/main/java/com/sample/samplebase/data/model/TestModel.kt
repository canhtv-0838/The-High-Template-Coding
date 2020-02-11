package com.sample.samplebase.data.model

import com.google.gson.annotations.SerializedName

data class TestModel (
    @SerializedName("result_code")
    val resultCode: Int,
    @SerializedName("request_code")
    val errorCode: Int,
    @SerializedName("data")
    val data: String
)
