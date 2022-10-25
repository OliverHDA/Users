package com.example.users.data.api

import com.example.users.model.Response
import com.example.users.model.Users
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SitecApi {

    @GET("hs/MobileClient/{IMEI}/form/users/")
    fun getUsers(
        @Path("IMEI") IMEI: String = "1223334444"
    ): Single<Users>

    @GET("hs/MobileClient/{IMEI}/authentication/")
    fun signIn(
        @Path("IMEI") IMEI: String,
        @Query("uid") uid: String,
        @Query("pass") pass: String,
        @Query("copyFromDevice") copyFromDevice: Boolean,
        @Query("nfc") nfc: String
    ): Single<Response>
}