package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.data.dataSource.local.AddressLocalDataSource
import com.svstudio.eccomerceapp.data.repository.AuthRepositoryImpl
import com.svstudio.eccomerceapp.data.repository.CategoriesRepositoryImpl
import com.svstudio.eccomerceapp.data.dataSource.local.AuthLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.local.CategoriesLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.local.ProductsLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.local.ShoppingBagLocalDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.AddressRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.AuthRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.CategoriesRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.MercadoPagoRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.OrdersRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.ProductsRemoteDataSource
import com.svstudio.eccomerceapp.data.dataSource.remote.UsersRemoteDataSource
import com.svstudio.eccomerceapp.data.repository.AddressRepositoryImpl
import com.svstudio.eccomerceapp.data.repository.MercadoPagoRepositoryImpl
import com.svstudio.eccomerceapp.data.repository.OrdersRepositoryImpl
import com.svstudio.eccomerceapp.data.repository.ProductsRepositoryImpl
import com.svstudio.eccomerceapp.data.repository.ShoppingBagRepositoryImpl
import com.svstudio.eccomerceapp.data.repository.UsersRepositoryImpl
import com.svstudio.eccomerceapp.domain.repository.AddressRepository
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.repository.CategoriesRepository
import com.svstudio.eccomerceapp.domain.repository.MercadoPagoRepository
import com.svstudio.eccomerceapp.domain.repository.OrdersRepository
import com.svstudio.eccomerceapp.domain.repository.ProductsRepository
import com.svstudio.eccomerceapp.domain.repository.ShoppingBagRepository
import com.svstudio.eccomerceapp.domain.repository.UsersRepository
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
        productsRemoteDataSource: ProductsRemoteDataSource,
        productsLocalDataSource: ProductsLocalDataSource
    ): ProductsRepository = ProductsRepositoryImpl(productsRemoteDataSource,productsLocalDataSource)
    @Provides
    fun provideShoppingBagRepository(
        shoppingBagLocalDataSource: ShoppingBagLocalDataSource
    ): ShoppingBagRepository = ShoppingBagRepositoryImpl(shoppingBagLocalDataSource)
    @Provides
    fun provideAddressRepository(
        addressRemoteDataSource: AddressRemoteDataSource,
        addressLocalDataSource: AddressLocalDataSource
    ): AddressRepository = AddressRepositoryImpl(addressRemoteDataSource,addressLocalDataSource)

    @Provides
    fun provideMercadoPagoRepository(
        mercadoPagoRemoteDataSource: MercadoPagoRemoteDataSource
    ): MercadoPagoRepository= MercadoPagoRepositoryImpl(mercadoPagoRemoteDataSource)
    @Provides
    fun provideOrdersRepository(
        ordersRemoteDataSource: OrdersRemoteDataSource
    ): OrdersRepository= OrdersRepositoryImpl(ordersRemoteDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)

}