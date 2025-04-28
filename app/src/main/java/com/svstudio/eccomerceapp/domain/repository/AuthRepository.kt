package com.svstudio.eccomerceapp.domain.repository

import com.svstudio.eccomerceapp.domain.model.AuthResponse

interface AuthRepository {
    suspend fun login(email: String, password: String): com.svstudio.eccomerceapp.domain.until.Resource<AuthResponse>
}