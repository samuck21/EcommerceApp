package com.svstudio.eccomerceapp.data.dataSource.remote.service

import com.svstudio.eccomerceapp.domain.model.Address
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AddressService {
    @GET("address/user/{id_user}")
    suspend fun  findByUserAddress(
        @Path("id_user") idUser: String
    ): Response<List<Address>>

    @POST("address")
    suspend fun  create(
        @Body address: Address
    ):retrofit2.Response<Address>
}