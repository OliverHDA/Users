package com.example.users.data.repository

import com.example.users.data.localstorage.RoomDB
import com.example.users.data.localstorage.historymapper.HistoryMapper
import com.example.users.model.Authentication
import com.example.users.utils.ISchedulers
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val mapper: HistoryMapper,
    private val database: RoomDB,
    private val schedulers: ISchedulers
) : LocalRepository {

    override fun add(uid: String, authentication: Authentication): Completable =
        database
            .historyDao
            .add(mapper.toHistoryEntity(uid, authentication))
            .observeOn(schedulers.io)

    override fun getHistory(uid: String): Single<MutableList<Authentication>> =
        database
            .historyDao
            .getHistory(uid).map { entityList ->
                entityList.map { mapper.toAuthentication(it) }.toMutableList()  }
            .observeOn(schedulers.io)
}