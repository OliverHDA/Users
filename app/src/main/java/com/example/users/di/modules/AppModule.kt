package com.example.users.di.modules

import com.example.users.data.localstorage.historymapper.HistoryMapper
import com.example.users.data.localstorage.historymapper.HistoryMapperImpl
import com.example.users.data.repository.LocalRepository
import com.example.users.data.repository.LocalRepositoryImpl
import com.example.users.data.repository.RemoteRepository
import com.example.users.data.repository.RemoteRepositoryImpl
import com.example.users.utils.ISchedulers
import com.example.users.utils.SchedulersProvider
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun bindRemoteRepository(repository: RemoteRepositoryImpl): RemoteRepository

    @Binds
    fun bindLocalRepository(repository: LocalRepositoryImpl): LocalRepository

    @Binds
    fun bindsSchedulers(schedulers: SchedulersProvider): ISchedulers

    @Binds
    fun bindsHistoryMapper(mapper: HistoryMapperImpl): HistoryMapper
}