package com.svstudio.eccomerceapp.data.repository.dataImpl

import com.svstudio.eccomerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.svstudio.eccomerceapp.data.service.AuthService
import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl (private val authService: AuthService): AuthRemoteDataSource {
    override suspend fun  login(email: String,password: String) = authService.login(email,password)
    override suspend fun register(user: User): Response<AuthResponse>  = authService.register(user)
}