package com.svstudio.eccomerceapp.domain.repository

import com.svstudio.eccomerceapp.domain.model.Order
import com.svstudio.eccomerceapp.domain.until.Resource
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {
    fun findAll(): Flow<Resource<List<Order>>>
    fun findByClient(idClient: String): Flow<Resource<List<Order>>>
    suspend fun updateStatus(id: String): Resource<Order>
}