package com.svstudio.eccomerceapp.data.repository

import com.svstudio.eccomerceapp.data.dataSource.remote.CategoriesRemoteDataSource
import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.domain.repository.CategoriesRepository
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.until.ResponseToRequest
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.io.File

class CategoriesRepositoryImpl (private val  categoriesRemoteDataSource: CategoriesRemoteDataSource) :
    CategoriesRepository {
    override suspend fun create(category: Category, file: File): Resource<Category> = ResponseToRequest.send(
        categoriesRemoteDataSource.create(category,file)
    )
    override fun getCatefories(): Flow<Resource<List<Category>>> = callbackFlow {

        trySend(ResponseToRequest.send(categoriesRemoteDataSource.getCategories()))
        awaitClose{
            cancel()
        }
    }

    override suspend fun update(
        id: String,
        category: Category
    ): Resource<Category> = ResponseToRequest.send(
        categoriesRemoteDataSource.update(id,category)
    )

    override suspend fun updateWithImage(
        id: String,
        category: Category,
        file: File
    ): Resource<Category> = ResponseToRequest.send(
        categoriesRemoteDataSource.updateWithImage(id,category,file)
    )
    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }
}