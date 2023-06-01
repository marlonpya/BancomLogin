package com.example.bancomlogin.data.utils

import com.google.gson.Gson

inline fun <reified T> String.toObject(): T? {
    return Gson().fromJson<T>(this, T::class.java)
}