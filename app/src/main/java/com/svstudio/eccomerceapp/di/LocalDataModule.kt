package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.dataSource.local.datastore.AuthDatastore
import com.svstudio.eccomerceapp.data.dataSource.local.AuthLocalDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.local.AuthLocalDataSource
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