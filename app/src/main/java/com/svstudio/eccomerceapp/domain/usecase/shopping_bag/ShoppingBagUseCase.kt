package com.svstudio.eccomerceapp.domain.usecase.shopping_bag

data class ShoppingBagUseCase(
    val add: AddUseCase,
    val delete: DeleteUseCase,
    val findAll: FindAllShoppingBagUseCase,
    val findById: FindByIdShoppingBagUseCase
)
