package com.svstudio.eccomerceapp.data.repository

import android.util.Log
import com.svstudio.eccomerceapp.data.dataSource.local.ShoppingBagLocalDataSource
import com.svstudio.eccomerceapp.data.mapper.toEntity
import com.svstudio.eccomerceapp.data.mapper.toShoppingBagProduct
import com.svstudio.eccomerceapp.domain.model.ShoppingBagProduct
import com.svstudio.eccomerceapp.domain.repository.ShoppingBagRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ShoppingBagRepositoryImpl(private  val localDataSource: ShoppingBagLocalDataSource): ShoppingBagRepository {
    override suspend fun add(product: ShoppingBagProduct) {
        CoroutineScope(Dispatchers.IO).launch {
            val shoppingBag = localDataSource.findById(product.id)

            if(shoppingBag == null){
                Log.d("ShoppingBagRepositoryImpl","Creando datos")
                localDataSource.insert(product.toEntity())
            }else{
                Log.d("ShoppingBagRepositoryImpl","Actualizando")
                localDataSource.update(product.id,product.quantity)
            }

        }
    }

    override suspend fun delete(id: String) {
       localDataSource.delete(id)
    }

    override fun findAll(): Flow<List<ShoppingBagProduct>> = flow {
        localDataSource.findAll().collect {
            emit(it.map { entity -> entity.toShoppingBagProduct() })
        }
    }
}