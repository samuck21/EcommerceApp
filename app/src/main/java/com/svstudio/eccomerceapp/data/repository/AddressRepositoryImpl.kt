package com.svstudio.eccomerceapp.data.repository

import com.svstudio.eccomerceapp.data.dataSource.remote.AddressRemoteDataSource
import com.svstudio.eccomerceapp.domain.model.Address
import com.svstudio.eccomerceapp.domain.repository.AddressRepository
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.until.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AddressRepositoryImpl (private val remoteDataSource: AddressRemoteDataSource):
    AddressRepository{
    override suspend fun create(address: Address): Resource<Address> = ResponseToRequest.send(
        remoteDataSource.create(address)
    )

    override fun findByUserAddress(idUser: String): Flow<Resource<List<Address>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByUserAddress(idUser)))
    }
}