package com.svstudio.eccomerceapp.data.repository

import com.svstudio.eccomerceapp.data.dataSource.remote.ProductsRemoteDataSource
import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.domain.repository.ProductsRepository
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.until.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.File

class ProductsRepositoryImpl(private val productsRemoteDataSource: ProductsRemoteDataSource): ProductsRepository {
    override fun findAll(): Flow<Resource<List<Product>>> {
        TODO("Not yet implemented")
    }

    override fun findByCategory(idCategory: String): Flow<Resource<List<Product>>> = flow {
        emit(
            ResponseToRequest.send(
                productsRemoteDataSource.findByCategory(idCategory)
            )
        )
    }

    override suspend fun create(
        product: Product,
        files: List<File>
    ): Resource<Product> = ResponseToRequest.send(
        productsRemoteDataSource.create(product,files)
    )
    override suspend fun update(
        id: String,
        product: Product
    ): Resource<Product> = ResponseToRequest.send(
        productsRemoteDataSource.update(id,product)
    )
    override suspend fun updateWithImage(
        id: String,
        product: Product,
        files: List<File>?
    ): Resource<Product> = ResponseToRequest.send(
        productsRemoteDataSource.updateWithImage(id,product,files)
    )
    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }
}