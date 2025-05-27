package com.svstudio.eccomerceapp.data.repository

import com.svstudio.eccomerceapp.data.dataSource.remote.OrdersRemoteDataSource
import com.svstudio.eccomerceapp.domain.model.Order
import com.svstudio.eccomerceapp.domain.repository.OrdersRepository
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.until.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class OrdersRepositoryImpl(private val remoteDataSource: OrdersRemoteDataSource): OrdersRepository {

    override fun findAll(): Flow<Resource<List<Order>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findAll()))
    }

    override fun findByClient(idClient: String): Flow<Resource<List<Order>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByClient(idClient)))
    }

    override suspend fun updateStatus(id: String): Resource<Order> = ResponseToRequest.send(
        remoteDataSource.updateStatus(id)
    )
}