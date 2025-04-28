package com.svstudio.eccomerceapp.data.repository.dataImpl

import com.svstudio.eccomerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.svstudio.eccomerceapp.data.service.AuthService

class AuthRemoteDataSourceImpl (private val authService: AuthService): AuthRemoteDataSource {
    override suspend fun  login(email: String,password: String) = authService.login(email,password)
}