package com.example.users

import com.example.users.di.ApplicationComponent
import com.example.users.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App: DaggerApplication() {
    private val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .build()
    }

    override fun applicationInjector(): AndroidInjector<App> =
        applicationComponent
}