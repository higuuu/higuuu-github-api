package com.example.higuuugithubapi

import com.example.higuuugithubapi.di.AppModule
import com.example.higuuugithubapi.di.ApplicationComponent
import com.example.higuuugithubapi.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App: DaggerApplication() {
    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.factory()
            .create(AppModule(this))
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return applicationComponent
    }
}