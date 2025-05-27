package com.svstudio.eccomerceapp.data.dataSource.remote

import com.svstudio.eccomerceapp.data.dataSource.remote.service.OrdersService
import com.svstudio.eccomerceapp.domain.model.Order
import retrofit2.Response


class OrdersRemoteDataSourceImpl(private val ordersService: OrdersService): OrdersRemoteDataSource {
    override suspend fun findAll(): Response<List<Order>> = ordersService.findAll()
    override suspend fun findByClient(idClient: String): Response<List<Order>> = ordersService.findByClient(idClient)
    override suspend fun updateStatus(id: String): Response<Order> = ordersService.updateStatus(id)
}