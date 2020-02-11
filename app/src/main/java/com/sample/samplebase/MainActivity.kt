package com.sample.samplebase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    val viewModel : TestViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.getData()
    }
}
