package com.svstudio.eccomerceapp.data.repository.dataSource

import com.svstudio.eccomerceapp.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface  AuthLocalDataSource {
    suspend fun  saveSession(authResponse: AuthResponse)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>

}