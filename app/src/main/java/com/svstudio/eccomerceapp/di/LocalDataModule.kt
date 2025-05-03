package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.datastore.AuthDatastore
import com.svstudio.eccomerceapp.data.repository.dataImpl.AuthLocalDataSourceImpl
import com.svstudio.eccomerceapp.data.repository.dataImpl.AuthRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.repository.dataSource.AuthLocalDataSource
import com.svstudio.eccomerceapp.data.repository.dataSource.AuthRemoteDataSource
import com.svstudio.eccomerceapp.data.service.AuthService
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
}