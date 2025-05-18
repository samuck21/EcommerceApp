package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.remote.CategoriesRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.remote.AuthRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.CategoriesRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.service.AuthService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.CategoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource =
        AuthRemoteDataSourceImpl(authService)
    @Provides
    fun provideCategoriesRemoteDataSource(categoriesService: CategoriesService): CategoriesRemoteDataSource =
        CategoriesRemoteDataSourceImpl(categoriesService)
}