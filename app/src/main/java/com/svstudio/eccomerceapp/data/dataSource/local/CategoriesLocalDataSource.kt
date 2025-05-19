package com.svstudio.eccomerceapp.data.dataSource.local

import com.svstudio.eccomerceapp.data.dataSource.local.entity.CategoryEntity
import com.svstudio.eccomerceapp.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoriesLocalDataSource {
    suspend fun create(category: CategoryEntity)
    suspend fun insertAll(categories:List<CategoryEntity>)
    fun getCategories(): Flow<List<CategoryEntity>>
    suspend fun update(id: String, name: String, description: String, image: String)
    suspend fun delete(id:String)
}