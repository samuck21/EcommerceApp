package com.svstudio.eccomerceapp.domain.until

import coil3.network.HttpException
import com.svstudio.eccomerceapp.domain.model.ErrorResponse
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {
    fun <T> send(result: Response<T>): Resource<T>{
        return  try {
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