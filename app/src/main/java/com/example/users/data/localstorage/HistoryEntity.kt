package com.example.users.data.localstorage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val uid: String,
    val response: Boolean,
    val continueWork: Boolean,
    val photoHash: String,
    val currentDate: String
)