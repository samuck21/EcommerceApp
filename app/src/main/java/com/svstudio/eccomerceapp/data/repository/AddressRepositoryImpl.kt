package com.svstudio.eccomerceapp.data.repository

import com.svstudio.eccomerceapp.data.dataSource.local.AddressLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.AddressRemoteDataSource
import com.svstudio.eccomerceapp.data.mapper.toAddress
import com.svstudio.eccomerceapp.data.mapper.toEntity
import com.svstudio.eccomerceapp.data.mapper.toProduct
import com.svstudio.eccomerceapp.data.mapper.toProductEntity
import com.svstudio.eccomerceapp.domain.model.Address
import com.svstudio.eccomerceapp.domain.repository.AddressRepository
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.until.ResponseToRequest
import com.svstudio.eccomerceapp.domain.until.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AddressRepositoryImpl (
    private val remoteDataSource: AddressRemoteDataSource,
    private  val localDataSource: AddressLocalDataSource
):
    AddressRepository{
    override suspend fun create(address: Address): Resource<Address> {
        ResponseToRequest.send(remoteDataSource.create(address)).run {
            return  when(this){
                is Resource.Success ->{
                    localDataSource.insert(this.data.toEntity())
                    Resource.Success(this.data)
                }
                else ->{
                    Resource.Failure("Error Desconocido")
                }
            }
        }
    }

    override fun findByUserAddress(idUser: String): Flow<Resource<List<Address>>> = flow {
        localDataSource.findByUser(idUser).collect() {
            it.run {
                val addressLocalMap = this.map { AddressEntity -> AddressEntity.toAddress()  }
                try {
                    ResponseToRequest.send(remoteDataSource.findByUserAddress(idUser)).run {
                        when(this) {
                            is Resource.Success -> {
                                val addressRemote = this.data

                                if (!isListEqual(addressRemote, addressLocalMap)) {
                                    localDataSource.insertAll(addressRemote.map { address -> address.toEntity() })
                                }

                                emit(Resource.Success(addressRemote))
                            }
                            else -> {
                                emit(Resource.Success(addressLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(addressLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)
}