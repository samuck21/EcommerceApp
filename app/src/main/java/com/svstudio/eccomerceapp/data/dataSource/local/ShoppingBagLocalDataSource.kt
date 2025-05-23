package com.svstudio.eccomerceapp.data.dataSource.local

import com.svstudio.eccomerceapp.data.dataSource.local.entity.CategoryEntity
import com.svstudio.eccomerceapp.data.dataSource.local.entity.ProductEntity
import com.svstudio.eccomerceapp.data.dataSource.local.entity.ShoppingBagProductEntity
import com.svstudio.eccomerceapp.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface ShoppingBagLocalDataSource {
    suspend fun insert(product: ShoppingBagProductEntity)
    suspend fun insertAll(products:List<ShoppingBagProductEntity>)
    fun findAll(): Flow<List<ShoppingBagProductEntity>>
    fun findById(id: String): ShoppingBagProductEntity
    suspend fun update(id: String,quantity: Int)
    suspend fun delete(id:String)
}