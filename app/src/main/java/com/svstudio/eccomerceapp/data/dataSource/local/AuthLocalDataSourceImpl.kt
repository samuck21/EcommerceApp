package com.svstudio.eccomerceapp.data.dataSource.local

import com.svstudio.eccomerceapp.data.dataSource.local.datastore.AuthDatastore
import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.model.User
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore) : AuthLocalDataSource{
    override suspend fun saveSession(authResponse: AuthResponse)  = authDatastore.save(authResponse)
    override suspend fun logout() =authDatastore.delete()
    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()
    override suspend fun updateSession(user: User) = authDatastore.update(user)
}