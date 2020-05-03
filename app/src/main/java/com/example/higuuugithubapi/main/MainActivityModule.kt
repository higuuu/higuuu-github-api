package com.example.higuuugithubapi.main

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector
    fun contributeMainActivityComponent(): MainActivity
}