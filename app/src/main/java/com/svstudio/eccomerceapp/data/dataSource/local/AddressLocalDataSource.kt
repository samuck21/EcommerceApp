package com.svstudio.eccomerceapp.data.dataSource.local

import com.svstudio.eccomerceapp.data.dataSource.local.entity.AddressEntity
import com.svstudio.eccomerceapp.data.dataSource.local.entity.CategoryEntity
import com.svstudio.eccomerceapp.domain.model.Address
import com.svstudio.eccomerceapp.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface AddressLocalDataSource {
    suspend fun insert(address: AddressEntity)
    suspend fun insertAll(address:List<AddressEntity>)
    fun findByUser(idUser: String): Flow<List<AddressEntity>>
    suspend fun update(id: String, address: String, neighborhood: String)
    suspend fun delete(id:String)
}