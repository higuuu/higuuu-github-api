package com.example.higuuugithubapi.di

import com.example.higuuugithubapi.App
import com.example.higuuugithubapi.main.MainActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        MainActivityModule::class,
        NetworkModule::class,
        AppModule::class
    ]
)


interface ApplicationComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory{
        fun create(appModule: AppModule): ApplicationComponent
    }
}