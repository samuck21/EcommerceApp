package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.repository.AuthRepositoryImpl
import com.svstudio.eccomerceapp.data.repository.dataImpl.AuthRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.svstudio.eccomerceapp.data.service.AuthService
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideAuthRemoteDataSource(authRemoteDataSource: AuthRemoteDataSource): AuthRepository =
        AuthRepositoryImpl(authRemoteDataSource)
}