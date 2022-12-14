package com.example.users.data.localstorage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [HistoryEntity::class],
    version = 1,
    exportSchema = false)

abstract class RoomDB : RoomDatabase() {
    abstract val historyDao: HistoryDao
}