package com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create.mapper

import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create.AdminProductCreateState

fun AdminProductCreateState.toProduct(): Product{
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price
    )
}