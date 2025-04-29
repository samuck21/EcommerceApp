package com.svstudio.eccomerceapp.domain.repository

import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.until.Resource
interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun  register(user: User) : Resource<AuthResponse>
}