package com.svstudio.eccomerceapp.data.repository

import coil3.network.HttpException
import com.svstudio.eccomerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.svstudio.eccomerceapp.domain.model.AuthResponse
import com.svstudio.eccomerceapp.domain.model.ErrorResponse
import com.svstudio.eccomerceapp.domain.model.User
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.until.ConvertErrorBody
import com.svstudio.eccomerceapp.domain.until.Resource
import java.io.IOException

class AuthRepositoryImpl (private  val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String,password : String): Resource<AuthResponse>{
      return  try {
         val result = authRemoteDataSource.login(email,password)
          if(result.isSuccessful) {
              Resource.Success(result.body()!!)
          } else {
            val  errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
              Resource.Failure(errorResponse?.message?:"Error desconocido")
          }
      } catch (e : Exception){
          e.printStackTrace()
          Resource.Failure(e.message?:"Error desconocido")

      }
      catch (e : HttpException){
          e.printStackTrace()
          Resource.Failure(e.message?:"Error desconocido")

      }
      catch (e : IOException){
          e.printStackTrace()
          Resource.Failure(e.message?:"Error desconocido")

      }

    }

    override suspend fun register(user: User): Resource<AuthResponse> {
        return  try {
            val result = authRemoteDataSource.register(user)
            if(result.isSuccessful) {
                Resource.Success(result.body()!!)
            } else {
                val  errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message?:"Error desconocido")
            }
        } catch (e : Exception){
            e.printStackTrace()
            Resource.Failure(e.message?:"Error desconocido")

        }
        catch (e : HttpException){
            e.printStackTrace()
            Resource.Failure(e.message?:"Error desconocido")

        }
        catch (e : IOException){
            e.printStackTrace()
            Resource.Failure(e.message?:"Error desconocido")

        }
    }
}