package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.repository.AuthRepositoryImpl
import com.svstudio.eccomerceapp.data.repository.dataImpl.AuthLocalDataSourceImpl
import com.svstudio.eccomerceapp.data.repository.dataImpl.AuthRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.repository.CategoriesRepositoryImpl
import com.svstudio.eccomerceapp.data.repository.dataSource.AuthLocalDataSource
import com.svstudio.eccomerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.svstudio.eccomerceapp.data.repository.dataSource.CategoriesRemoteDataSource
import com.svstudio.eccomerceapp.data.service.AuthService
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.repository.CategoriesRepository
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
    ): CategoriesRepository = CategoriesRepositoryImpl(categoriesRemoteDataSource)
}