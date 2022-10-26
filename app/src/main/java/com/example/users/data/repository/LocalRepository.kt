package com.example.users.data.repository

import com.example.users.model.Authentication
import io.reactivex.Completable
import io.reactivex.Single

interface LocalRepository {
    fun add(uid: String, authentication: Authentication): Completable
    fun getHistory(uid: String): Single<MutableList<Authentication>>
}