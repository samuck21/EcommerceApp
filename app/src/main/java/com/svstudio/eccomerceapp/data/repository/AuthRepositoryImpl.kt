package com.svstudio.eccomerceapp.data.repository

import com.svstudio.eccomerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.until.Result
class AuthRepositoryImpl (private  val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String,password : String): Result<User>{
      return  try {
         val result = authRemoteDataSource.login(email,password)
         Result.Success(result.body()!!)

      } catch (e : Exception){
          e.printStackTrace()
          Result.Failure(e)

      }
    }
}