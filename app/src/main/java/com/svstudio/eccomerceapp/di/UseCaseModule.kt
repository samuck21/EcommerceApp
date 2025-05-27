package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.domain.repository.AddressRepository
import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.repository.CategoriesRepository
import com.svstudio.eccomerceapp.domain.repository.MercadoPagoRepository
import com.svstudio.eccomerceapp.domain.repository.ProductsRepository
import com.svstudio.eccomerceapp.domain.repository.ShoppingBagRepository
import com.svstudio.eccomerceapp.domain.usecase.address.AddressUseCase
import com.svstudio.eccomerceapp.domain.usecase.address.CreateAddressUseCase
import com.svstudio.eccomerceapp.domain.usecase.address.FindByUserAddressUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.AuthUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.GetSessionDataUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.LoginUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.LogoutUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.RegisterUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.SaveSessionUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.UpdateSessionUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.CategoriesUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.CreateCategoryUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.DeleteCategoryUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.GetCategoryUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.UpdateCategoryUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.UpdateCategoryWithImageUseCase
import com.svstudio.eccomerceapp.domain.usecase.mercadopago.CreateCardTokenUseCase
import com.svstudio.eccomerceapp.domain.usecase.mercadopago.CreatePaymentUseCase
import com.svstudio.eccomerceapp.domain.usecase.mercadopago.GetIdentificationTypeUseCase
import com.svstudio.eccomerceapp.domain.usecase.mercadopago.GetInstallmentsUseCase
import com.svstudio.eccomerceapp.domain.usecase.mercadopago.MercadoPagoUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.CreateProductUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.DeleteProductUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.FindAllUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.FindByCategoryUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.ProductsUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.UpdateProductUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.UpdateProductWithImageUseCase
import com.svstudio.eccomerceapp.domain.usecase.shopping_bag.AddUseCase
import com.svstudio.eccomerceapp.domain.usecase.shopping_bag.DeleteUseCase
import com.svstudio.eccomerceapp.domain.usecase.shopping_bag.FindAllShoppingBagUseCase
import com.svstudio.eccomerceapp.domain.usecase.shopping_bag.FindByIdShoppingBagUseCase
import com.svstudio.eccomerceapp.domain.usecase.shopping_bag.GetTotalUseCase
import com.svstudio.eccomerceapp.domain.usecase.shopping_bag.ShoppingBagUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository),
        updateSession = UpdateSessionUseCase(authRepository)
    )
    @Provides
    fun provideCategoriesUseCase(categoriesRepository: CategoriesRepository) = CategoriesUseCase(
        createCategory = CreateCategoryUseCase(categoriesRepository),
        getCategories = GetCategoryUseCase(categoriesRepository),
        updateCategory = UpdateCategoryUseCase(categoriesRepository),
        updateCategoryWithImage = UpdateCategoryWithImageUseCase(categoriesRepository),
        deleteCategory = DeleteCategoryUseCase(categoriesRepository)

    )
    @Provides
    fun provideProductsUseCase(productsRepository: ProductsRepository) = ProductsUseCase(
        createProduct = CreateProductUseCase(productsRepository),
        findByCategory = FindByCategoryUseCase(productsRepository),
        findAll = FindAllUseCase(productsRepository),
        updateProduct = UpdateProductUseCase(productsRepository),
        updateProductWithImage = UpdateProductWithImageUseCase(productsRepository),
        deleteProduct = DeleteProductUseCase(productsRepository)

    )
    @Provides
    fun provideShoppingBagUseCase(shoppingBagRepository: ShoppingBagRepository) =
        ShoppingBagUseCase(
            add = AddUseCase(shoppingBagRepository),
            delete = DeleteUseCase(shoppingBagRepository),
            findAll = FindAllShoppingBagUseCase(shoppingBagRepository),
            findById = FindByIdShoppingBagUseCase(shoppingBagRepository),
            getTotal = GetTotalUseCase(shoppingBagRepository)

        )
    @Provides
    fun provideAddressUseCase(addressRepository: AddressRepository) =
        AddressUseCase(
            createAddress = CreateAddressUseCase(addressRepository),
            findByUserAddress = FindByUserAddressUseCase(addressRepository)
        )
    @Provides
    fun provideMercadoPagoUseCase(mercadoPagoRepository: MercadoPagoRepository) =
        MercadoPagoUseCase(
            getIdentificationType = GetIdentificationTypeUseCase(mercadoPagoRepository),
            getInstallments = GetInstallmentsUseCase(mercadoPagoRepository),
            createCardToken = CreateCardTokenUseCase(mercadoPagoRepository),
            createPayment = CreatePaymentUseCase(mercadoPagoRepository)
        )
}