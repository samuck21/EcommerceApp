package com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.update.mapper

import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create.AdminProductCreateState
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.update.AdminProductUpdateState

fun AdminProductUpdateState.toProduct(): Product{
    return Product(
        name = name,
        description = description,
        idCategory = idCategory,
        price = price
    )
}