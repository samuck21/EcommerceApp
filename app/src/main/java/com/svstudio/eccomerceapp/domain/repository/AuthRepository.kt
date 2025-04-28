package com.svstudio.eccomerceapp.domain.repository

import com.svstudio.eccomerceapp.domain.model.User
import kotlin.Result

interface AuthRepository {
    suspend fun login(email: String, password: String): com.svstudio.eccomerceapp.domain.until.Result<User>
}