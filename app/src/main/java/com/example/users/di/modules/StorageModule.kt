package com.example.users.di.modules

import android.content.Context
import androidx.room.Room
import com.example.users.data.localstorage.RoomDB
import dagger.Module
import dagger.Provides

@Module
class StorageModule {
    @Provides
    fun provideDataBase(context: Context): RoomDB = Room.databaseBuilder(
        context,
        RoomDB::class.java,
        "UsersDB"
    )
        .fallbackToDestructiveMigration()
        .build()
}