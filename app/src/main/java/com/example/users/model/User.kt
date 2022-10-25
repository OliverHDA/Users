package com.example.users.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("User") val user: String,
    @SerializedName("Uid") val uid: String,
    @SerializedName("Language") val language: String
)