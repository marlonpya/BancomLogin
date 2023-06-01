package com.example.bancomlogin.data

object RestApi {
    private const val PROTOCOL = "https://"
    private const val HOST_PORT = "jsonplaceholder.typicode.com"
    private const val APPLICATION_CONTEXT = ""
    private const val VERSION = ""
    private const val RESOURCE = ""
    const val BASE_URL = PROTOCOL + HOST_PORT + APPLICATION_CONTEXT + VERSION + RESOURCE
    const val BASE_URL_NAME = "BASE_URL"

    const val TIMEOUT = 60L

    object USERS {

        const val LIST_USERS = "users"

    }

    object RESPONSE_CODE {
        const val OK = 200

        const val EXPIRED_PASSWORD = 1001
        const val BLOCKED_PASSWORD = 1002
    }
}