package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.dataSource.local.datastore.AuthDatastore
import com.svstudio.eccomerceapp.data.dataSource.remote.service.AddressService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.AuthService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.CategoriesService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.MercadoPagoService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.OrdersService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.ProductsService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.UsersService
import com.svstudio.eccomerceapp.domain.model.Order
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(datastore: AuthDatastore) = OkHttpClient.Builder().addInterceptor {
        val token = runBlocking {
            datastore.getData().first().token
        }
        val newRequest = it.request().newBuilder().addHeader("Authorization", token ?: "").build()
        it.proceed(newRequest)
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit
               .Builder()
            .baseUrl("http://192.168.10.188:3000/")
            .client(okHttpClient)
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
    @Provides
    @Singleton
    fun provideMercadoPagoService(retrofit: Retrofit): MercadoPagoService {
        return retrofit.create(MercadoPagoService::class.java)
    }
    @Provides
    @Singleton
    fun provideOrderService(retrofit: Retrofit): OrdersService {
        return retrofit.create(OrdersService::class.java)
    }
    @Provides
    @Singleton
    fun provideUsersService(retrofit: Retrofit): UsersService{
        return retrofit.create(UsersService::class.java)
    }

}