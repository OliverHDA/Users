package com.example.users.di.modules

import com.example.users.data.repository.Repository
import com.example.users.data.repository.RepositoryImpl
import com.example.users.utils.ISchedulers
import com.example.users.utils.SchedulersProvider
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun bindRepository(repository: RepositoryImpl): Repository

    @Binds
    fun bindsSchedulers(schedulers: SchedulersProvider): ISchedulers
}