package com.svstudio.eccomerceapp.data.dataSource.remote

import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {
    suspend fun  login(email: String,password: String): Response<AuthResponse>
    suspend fun  register(user: User): Response<AuthResponse>
}