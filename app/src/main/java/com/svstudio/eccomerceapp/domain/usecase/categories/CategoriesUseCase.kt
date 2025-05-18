package com.svstudio.eccomerceapp.domain.usecase.categories

data class CategoriesUseCase(
    val createCategory: CreateCategoryUseCase,
    val getCategories: GetCategoryUseCase,
    val updateCategory: UpdateCategoryUseCase,
    val updateCategoryWithImage: UpdateCategoryWithImageUseCase
)
