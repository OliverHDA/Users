package com.example.users.di.modules

import com.example.users.main.MainActivity
import com.example.users.screens.auth.AuthFragment
import com.example.users.screens.signinhistory.SignInHistoryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ContributesAndroidInjectorModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindAuthFragment(): AuthFragment

    @ContributesAndroidInjector
    fun bindSignInHistoryFragment(): SignInHistoryFragment
}