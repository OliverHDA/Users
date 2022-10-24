package com.example.users.di.modules

import com.example.users.auth.AuthFragment
import com.example.users.main.MainActivity
import com.example.users.visit.VisitHistoryFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ContributesAndroidInjectorModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindAuthFragment(): AuthFragment

    @ContributesAndroidInjector
    fun bindVisitHistoryFragment(): VisitHistoryFragment
}