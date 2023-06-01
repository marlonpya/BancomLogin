package com.example.bancomlogin.data.repository

import com.example.bancomlogin.data.error.UserException
import com.example.bancomlogin.data.model.AddressResponse
import com.example.bancomlogin.data.network.ApiErrorImpl
import com.example.bancomlogin.data.network.UserService
import com.example.bancomlogin.domain.CustomResult
import com.example.bancomlogin.domain.model.UserListEntity
import com.example.bancomlogin.domain.repository.UserRepository


class UserRepositoryImpl(
    private val api: UserService,
    private val apiError: ApiErrorImpl
) : UserRepository {

    override fun getUsers(): CustomResult<List<UserListEntity>> {
        val call = api.callUsers()?.execute()
        return if (apiError.isSuccess(call)) {
            CustomResult.OnSuccess(call?.body()?.map {
                UserListEntity(
                    it.name ?: "",
                    it.userName ?: "",
                    getAddress(it.address),
                    it.email ?: "",
                    it.phone ?: ""
                )
            }
                ?: emptyList())
        } else {
            val error = apiError.toError<UserException?>(call?.errorBody())
            CustomResult.OnError(
                com.example.bancomlogin.domain.UnknownError(
                    code = error?.code ?: "",
                    message = error?.description
                )
            )
        }
    }

    private fun getAddress(address: AddressResponse?): String {
        return "${address?.street}, ${address?.suite}, ${address?.city}, ${address?.zipcode}"
    }
}