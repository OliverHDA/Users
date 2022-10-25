package com.example.users.data.repository

import com.example.users.model.Response
import com.example.users.model.Users
import io.reactivex.Single

interface Repository {
    fun getUsers(): Single<Users>
    fun signIn(uid: String, pass: String): Single<Response>
}