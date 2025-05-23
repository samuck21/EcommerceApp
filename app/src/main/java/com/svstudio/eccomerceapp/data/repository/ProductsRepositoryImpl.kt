package com.svstudio.eccomerceapp.data.repository

import com.svstudio.eccomerceapp.data.dataSource.local.ProductsLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.ProductsRemoteDataSource
import com.svstudio.eccomerceapp.data.mapper.toProduct
import com.svstudio.eccomerceapp.data.mapper.toProductEntity
import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.domain.repository.ProductsRepository
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.until.ResponseToRequest
import com.svstudio.eccomerceapp.domain.until.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File

class ProductsRepositoryImpl(
    private val productsRemoteDataSource: ProductsRemoteDataSource,
    private  val  localDataSource: ProductsLocalDataSource

): ProductsRepository {
    override fun findAll(): Flow<Resource<List<Product>>> = flow {
        localDataSource.findAll().collect() {
            it.run {
                val productsLocalMap = this.map { productEntity -> productEntity.toProduct()  }
                try {
                    ResponseToRequest.send(productsRemoteDataSource.findAll()).run {
                        when(this) {
                            is Resource.Success -> {
                                val productsRemote = this.data

                                if (!isListEqual(productsRemote, productsLocalMap)) {
                                    localDataSource.insertAll(productsRemote.map { product -> product.toProductEntity() })
                                }

                                emit(Resource.Success(productsRemote))
                            }
                            else -> {
                                emit(Resource.Success(productsLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(productsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override fun findByCategory(idCategory: String): Flow<Resource<List<Product>>> = flow {
        localDataSource.findByCategory(idCategory).collect() {
            it.run {
                val productsLocalMap = this.map { productEntity -> productEntity.toProduct()  }
                try {
                    ResponseToRequest.send(productsRemoteDataSource.findByCategory(idCategory)).run {
                        when(this) {
                            is Resource.Success -> {
                                val productsRemote = this.data

                                if (!isListEqual(productsRemote, productsLocalMap)) {
                                    localDataSource.insertAll(productsRemote.map { product -> product.toProductEntity() })
                                }

                                emit(Resource.Success(productsRemote))
                            }
                            else -> {
                                emit(Resource.Success(productsLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(productsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)
    override suspend fun create(
        product: Product,
        files: List<File>
    ): Resource<Product> {

        ResponseToRequest.send(productsRemoteDataSource.create(product,files)).run {
            return  when(this){
                is Resource.Success ->{
                    localDataSource.insert(this.data.toProductEntity())
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido ")
                }
            }
        }
        }

    override suspend fun update(
        id: String,
        product: Product
    ): Resource<Product> {
        ResponseToRequest.send(productsRemoteDataSource.update(id,product)).run {
            return  when(this){
                is Resource.Success ->{
                    localDataSource.update(
                        id = this.data.id ?:"",
                        name = this.data.name,
                        description = this.data.description,
                        image1 = this.data.image1 ?:"",
                        image2 = this.data.image2 ?:"",
                        price = this.data.price
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido ")
                }
            }
        }
    }

    override suspend fun updateWithImage(
        id: String,
        product: Product,
        files: List<File>?
    ): Resource<Product> {
        ResponseToRequest.send(productsRemoteDataSource.updateWithImage(id,product,files)).run {
            return  when(this){
                is Resource.Success ->{
                    localDataSource.update(
                        id = this.data.id ?:"",
                        name = this.data.name,
                        description = this.data.description,
                        image1 = this.data.image1 ?:"",
                        image2 = this.data.image2 ?:"",
                        price = this.data.price
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido ")
                }
            }
        }
    }
    override suspend fun delete(id: String): Resource<Unit>{
        ResponseToRequest.send(productsRemoteDataSource.delete(id)).run {
            return  when(this){
                is Resource.Success ->{
                    localDataSource.delete(id)
                    Resource.Success(Unit)
                }
                else -> {
                    Resource.Failure("Error desconocido ")
                }
            }
        }
    }
}