package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.dataSource.remote.service.AddressService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.AuthService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.CategoriesService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.ProductsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit{
        return Retrofit
               .Builder()
            .baseUrl("http://192.168.10.188:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit): AuthService{
        return retrofit.create(AuthService::class.java)
    }
    @Provides
    @Singleton
    fun provideCategoriesService(retrofit: Retrofit): CategoriesService{
        return retrofit.create(CategoriesService::class.java)
    }


    @Provides
    @Singleton
    fun provideProductsService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }
    @Provides
    @Singleton
    fun provideAddressService(retrofit: Retrofit): AddressService {
        return retrofit.create(AddressService::class.java)
    }
}