package com.example.users.di

import android.content.Context
import com.example.users.di.modules.ApiModule
import com.example.users.di.modules.AppModule
import com.example.users.di.modules.ContributesAndroidInjectorModule
import com.example.users.main.App
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ContributesAndroidInjectorModule::class,
        ApiModule::class,
        AppModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        fun build(): ApplicationComponent
    }
}