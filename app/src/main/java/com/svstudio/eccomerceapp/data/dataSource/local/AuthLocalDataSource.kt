package com.svstudio.eccomerceapp.data.dataSource.local

import com.svstudio.eccomerceapp.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

interface  AuthLocalDataSource {
    suspend fun  saveSession(authResponse: AuthResponse)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>

}