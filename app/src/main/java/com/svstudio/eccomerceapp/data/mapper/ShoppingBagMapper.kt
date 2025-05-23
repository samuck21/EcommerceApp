package com.svstudio.eccomerceapp.data.mapper

import com.svstudio.eccomerceapp.data.dataSource.local.entity.ShoppingBagProductEntity
import com.svstudio.eccomerceapp.domain.model.ShoppingBagProduct

fun ShoppingBagProduct.toEntity() : ShoppingBagProductEntity{
    return ShoppingBagProductEntity(
        id = id,
        name = name,
        idCategory = idCategory,
        image1 = image1,
        price= price,
        quantity = quantity
    )
}
fun ShoppingBagProductEntity.toShoppingBagProduct () : ShoppingBagProduct{
    return ShoppingBagProduct(
        id = id,
        name = name,
        idCategory = idCategory,
        image1 = image1,
        price= price,
        quantity = quantity
    )
}