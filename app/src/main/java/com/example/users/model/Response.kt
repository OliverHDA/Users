package com.example.users.model

import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("Authentication") val authentication: Authentication?,
    @SerializedName("Code") val code: Int?,
)