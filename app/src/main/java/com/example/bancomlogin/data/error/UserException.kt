package com.example.bancomlogin.data.error

import com.google.gson.annotations.SerializedName

open class UserException (
    @SerializedName("code")open val code: String? = null,
    @SerializedName("description")open val description: String? = null,
    @SerializedName("errorType")open val errorType: String? = null
)