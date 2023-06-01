package com.example.bancomlogin.data.model

import com.google.gson.annotations.SerializedName

data class UserListResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("username") val userName: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("address") val address: AddressResponse?,
    @SerializedName("phone") val phone: String?
)