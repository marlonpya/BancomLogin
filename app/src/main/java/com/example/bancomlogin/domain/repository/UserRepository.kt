package com.example.bancomlogin.domain.repository

import com.example.bancomlogin.domain.CustomResult
import com.example.bancomlogin.domain.model.UserListEntity

interface UserRepository {

    fun getUsers(): CustomResult<List<UserListEntity>>
}