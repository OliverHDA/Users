package com.example.users.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("Users") val users: ListUsers
)