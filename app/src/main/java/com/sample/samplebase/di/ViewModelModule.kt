package com.sample.samplebase.di

import com.sample.samplebase.TestViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { TestViewModel(get()) }
} //TODO
