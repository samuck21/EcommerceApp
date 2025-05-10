package com.svstudio.eccomerceapp.data.repository.dataImpl

import com.svstudio.eccomerceapp.data.datastore.AuthDatastore
import com.svstudio.eccomerceapp.data.repository.dataSource.AuthLocalDataSource
import com.svstudio.eccomerceapp.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore) : AuthLocalDataSource{
    override suspend fun saveSession(authResponse: AuthResponse)  = authDatastore.save(authResponse)
    override suspend fun logout() =authDatastore.delete()
    override fun getSessionData(): Flow<AuthResponse>  = authDatastore.getData()
}