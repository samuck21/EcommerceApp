package com.svstudio.eccomerceapp.domain.repository

import com.svstudio.eccomerceapp.domain.model.ShoppingBagProduct
import kotlinx.coroutines.flow.Flow

interface ShoppingBagRepository {
    suspend fun add(product: ShoppingBagProduct )
    suspend fun  delete(id: String)
    fun findAll(): Flow<List<ShoppingBagProduct>>
    fun  findById(id: String): ShoppingBagProduct?
    suspend fun getTotal(): Double
}