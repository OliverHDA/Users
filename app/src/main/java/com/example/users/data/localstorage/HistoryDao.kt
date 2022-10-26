package com.example.users.data.localstorage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface HistoryDao {

    @Query("SELECT * FROM history WHERE uid = :uid")
    fun getHistory(uid: String): Single<List<HistoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(entity: HistoryEntity): Completable
}