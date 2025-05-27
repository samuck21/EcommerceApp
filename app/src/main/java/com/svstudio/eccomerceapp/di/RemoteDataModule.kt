package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.dataSource.remote.AddressRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.AddressRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.remote.CategoriesRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.remote.AuthRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.CategoriesRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.MercadoPagoRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.MercadoPagoRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.remote.OrdersRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.OrdersRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.remote.ProductsRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.service.AuthService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.CategoriesService
import com.svstudio.eccomerceapp.data.dataSource.remote.ProductsRemoteDataSourceImpl
import com.svstudio.eccomerceapp.data.dataSource.remote.service.AddressService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.MercadoPagoService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.OrdersService
import com.svstudio.eccomerceapp.data.dataSource.remote.service.ProductsService
import com.svstudio.eccomerceapp.domain.model.Product
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
    @Provides
    fun provideProductsRemoteDataSource(productsService: ProductsService): ProductsRemoteDataSource = ProductsRemoteDataSourceImpl(productsService)

    @Provides
    fun provideAddressRemoteDataSource(addressService: AddressService): AddressRemoteDataSource =
        AddressRemoteDataSourceImpl(addressService)

    @Provides
    fun provideMercadoPagoRemoteDataSource(mercadoPagoService: MercadoPagoService):
        MercadoPagoRemoteDataSource = MercadoPagoRemoteDataSourceImpl(mercadoPagoService)
    @Provides
    fun provideOrdersRemoteDataSource(ordersService: OrdersService):
            OrdersRemoteDataSource= OrdersRemoteDataSourceImpl(ordersService)
}