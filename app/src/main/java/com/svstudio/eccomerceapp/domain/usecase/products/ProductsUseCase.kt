package com.svstudio.eccomerceapp.domain.usecase.products

data class ProductsUseCase (
    val createProduct: CreateProductUseCase,
    val findByCategory: FindByCategoryUseCase,
    val updateProduct: UpdateProductUseCase,
    val updateProductWithImage: UpdateProductWithImageUseCase
)