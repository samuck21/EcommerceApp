package com.svstudio.eccomerceapp.data.dataSource.remote

import com.svstudio.eccomerceapp.data.dataSource.remote.service.AddressService
import com.svstudio.eccomerceapp.domain.model.Address
import retrofit2.Response

class AddressRemoteDataSourceImpl(private  val addressService: AddressService):
    AddressRemoteDataSource{
    override suspend fun create(address: Address): Response<Address> = addressService.create(address)
    override suspend fun findByUserAddress(idUser: String): Response<List<Address>> = addressService.findByUserAddress(idUser)
}