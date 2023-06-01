package com.example.bancomlogin.domain.usecase

import com.example.bancomlogin.domain.repository.UserRepository

class GetUsersUseCase(private val repository: UserRepository) {

    fun execute() = repository.getUsers()
}