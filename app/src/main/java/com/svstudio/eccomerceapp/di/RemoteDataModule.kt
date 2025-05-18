package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.repository.dataImpl.AuthRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.repository.dataImpl.CategoriesRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.svstudio.eccomerceapp.data.repository.dataSource.CategoriesRemoteDataSource
import com.svstudio.eccomerceapp.data.service.AuthService
import com.svstudio.eccomerceapp.data.service.CategoriesService
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