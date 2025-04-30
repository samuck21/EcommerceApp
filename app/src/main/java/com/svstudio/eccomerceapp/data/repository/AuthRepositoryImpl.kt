package com.svstudio.eccomerceapp.data.repository

import coil3.network.HttpException
import com.svstudio.eccomerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.model.ErrorResponse
import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.until.ConvertErrorBody
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.until.ResponseToRequest
import java.io.IOException

class AuthRepositoryImpl (private  val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String,password : String): Resource<AuthResponse> =
        ResponseToRequest.send(
            authRemoteDataSource.login(email,password)
        )

    override suspend fun register(user: User): Resource<AuthResponse>  = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )
}