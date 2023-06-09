package com.example.bancomlogin.data.network

import com.example.bancomlogin.data.RestApi
import retrofit2.Response

open class ApiErrorImpl: ApiError() {

    fun <T> isSuccess(poResponse: Response<T?>?, vararg codesSuccess: Int): Boolean {
        return poResponse != null &&
                poResponse.isSuccessful &&
                codesSuccess.any { poResponse.code() == it }
    }

    override fun <T> isSuccess(poResponse: Response<T?>?): Boolean {
        return isSuccess(poResponse, RestApi.RESPONSE_CODE.OK)
    }
}