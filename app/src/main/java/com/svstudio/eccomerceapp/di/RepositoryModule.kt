package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.repository.AuthRepositoryImpl
import com.svstudio.eccomerceapp.data.repository.CategoriesRepositoryImpl
import com.svstudio.eccomerceapp.data.dataSource.local.AuthLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.local.CategoriesLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.AuthRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.CategoriesRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.ProductsRemoteDataSource
import com.svstudio.eccomerceapp.data.repository.ProductsRepositoryImpl
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.repository.CategoriesRepository
import com.svstudio.eccomerceapp.domain.repository.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthRemoteDataSource(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource

    ): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource,authLocalDataSource)
    @Provides
    fun provideCategoriesRepository(
     categoriesRemoteDataSource: CategoriesRemoteDataSource,
     categoriesLocalDataSource: CategoriesLocalDataSource
    ): CategoriesRepository = CategoriesRepositoryImpl(categoriesRemoteDataSource,categoriesLocalDataSource)
    @Provides
    fun provideProductsRepository(
        productsRemoteDataSource: ProductsRemoteDataSource
    ): ProductsRepository = ProductsRepositoryImpl(productsRemoteDataSource)
}