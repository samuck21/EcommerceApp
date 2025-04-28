package com.svstudio.eccomerceapp.data.repository

import com.svstudio.eccomerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.until.Resource
class AuthRepositoryImpl (private  val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String,password : String): Resource<AuthResponse>{
      return  try {
         val result = authRemoteDataSource.login(email,password)
         Resource.Success(result.body()!!)

      } catch (e : Exception){
          e.printStackTrace()
          Resource.Failure(e)

      }
    }
}