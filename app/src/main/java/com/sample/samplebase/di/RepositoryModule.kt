package com.sample.samplebase.di

import com.sample.samplebase.data.repository.TestRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { TestRepository(get()) }
} //TODO
