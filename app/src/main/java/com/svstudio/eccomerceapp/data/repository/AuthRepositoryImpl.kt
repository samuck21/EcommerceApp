package com.svstudio.eccomerceapp.data.repository

import com.svstudio.eccomerceapp.data.dataSource.local.AuthLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.AuthRemoteDataSource
import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.until.ResponseToRequest
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl (
    private  val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
): AuthRepository {
    override suspend fun login(email: String,password : String): Resource<AuthResponse> =
        ResponseToRequest.send(
            authRemoteDataSource.login(email,password)
        )

    override suspend fun register(user: User): Resource<AuthResponse>  = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) =authLocalDataSource.saveSession(authResponse)
    override suspend fun logout() = authLocalDataSource.logout()
    override fun getSessionData(): Flow<AuthResponse>  = authLocalDataSource.getSessionData()
}