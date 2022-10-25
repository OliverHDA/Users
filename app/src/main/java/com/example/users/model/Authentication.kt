package com.example.users.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Authentication(
    @SerializedName("Response") val response: Boolean,
    @SerializedName("ContinueWork") val continueWork: Boolean,
    @SerializedName("PhotoHash") val photoHash: String,
    @SerializedName("CurrentDate") val currentDate: String
): Parcelable