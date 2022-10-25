package com.example.users.data.repository

import com.example.users.data.api.SitecApi
import com.example.users.model.Response
import com.example.users.model.Users
import com.example.users.utils.ISchedulers
import io.reactivex.Single
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val api: SitecApi,
    private val schedulers: ISchedulers
) : Repository {
    override fun getUsers(): Single<Users> =
        api
            .getUsers()
            .subscribeOn(schedulers.io)

    override fun signIn(uid: String, pass: String): Single<Response> =
        api
            .signIn(
                IMEI = "1223334444",
                uid = uid,
                pass = pass,
                copyFromDevice = false,
                nfc = ""
            )
            .subscribeOn(schedulers.io)
}