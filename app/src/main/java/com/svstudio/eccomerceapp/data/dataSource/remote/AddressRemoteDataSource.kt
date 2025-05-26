package com.svstudio.eccomerceapp.data.dataSource.remote

import com.svstudio.eccomerceapp.domain.model.Address
import retrofit2.Response

interface AddressRemoteDataSource {
    suspend fun create(address: Address): Response<Address>
    suspend fun  findByUserAddress(idUser: String): Response<List<Address>>

}