package com.svstudio.eccomerceapp.di

import com.svstudio.eccomerceapp.domain.repository.AuthRepository
import com.svstudio.eccomerceapp.domain.repository.CategoriesRepository
import com.svstudio.eccomerceapp.domain.repository.ProductsRepository
import com.svstudio.eccomerceapp.domain.usecase.auth.AuthUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.GetSessionDataUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.LoginUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.LogoutUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.RegisterUseCase
import com.svstudio.eccomerceapp.domain.usecase.auth.SaveSessionUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.CategoriesUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.CreateCategoryUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.DeleteCategoryUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.GetCategoryUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.UpdateCategoryUseCase
import com.svstudio.eccomerceapp.domain.usecase.categories.UpdateCategoryWithImageUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.CreateProductUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.DeleteProductUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.FindByCategoryUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.ProductsUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.UpdateProductUseCase
import com.svstudio.eccomerceapp.domain.usecase.products.UpdateProductWithImageUseCase
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
        logout = LogoutUseCase(authRepository)
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
        updateProduct = UpdateProductUseCase(productsRepository),
        updateProductWithImage = UpdateProductWithImageUseCase(productsRepository),
        deleteProduct = DeleteProductUseCase(productsRepository)

    )
}