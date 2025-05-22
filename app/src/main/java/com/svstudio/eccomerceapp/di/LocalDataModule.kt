package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.dataSource.local.datastore.AuthDatastore
import com.svstudio.eccomerceapp.data.dataSource.local.AuthLocalDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.local.AuthLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.local.CategoriesLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.local.CategoriesLocalDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.local.ProductsLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.local.ProductsLocalDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.local.dao.CategoriesDao
import com.svstudio.eccomerceapp.data.dataSource.local.dao.ProductsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {
    @Provides
    fun provideAuthLocalDataSource(authDatastore: AuthDatastore): AuthLocalDataSource =
        AuthLocalDataSourceImpl(authDatastore)
    @Provides
    fun providerCategoriesLocalDataSource(categoriesDao: CategoriesDao) : CategoriesLocalDataSource =
        CategoriesLocalDataSourceImpl(categoriesDao)

    @Provides
    fun providerProductsLocalDataSource(productsDao: ProductsDao) : ProductsLocalDataSource =
        ProductsLocalDataSourceImpl(productsDao)
}