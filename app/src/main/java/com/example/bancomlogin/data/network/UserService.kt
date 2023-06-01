package com.example.bancomlogin.data.network

import com.example.bancomlogin.data.RestApi
import com.example.bancomlogin.data.model.UserListResponse
import retrofit2.Call
import retrofit2.http.*

interface UserService {

    @GET(RestApi.USERS.LIST_USERS)
    fun callUsers(): Call<List<UserListResponse>?>?
}