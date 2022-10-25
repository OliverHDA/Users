package com.example.users.model

import com.google.gson.annotations.SerializedName

data class ListUsers(
    @SerializedName("ListUsers") val users: List<User>
)