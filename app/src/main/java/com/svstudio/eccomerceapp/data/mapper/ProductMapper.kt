package com.svstudio.eccomerceapp.data.mapper

import com.svstudio.eccomerceapp.data.dataSource.local.entity.CategoryEntity
import com.svstudio.eccomerceapp.data.dataSource.local.entity.ProductEntity
import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.domain.model.Product

fun ProductEntity.toProduct(): Product {
    return Product(
        id=id,
        name =name,
        description =description,
        image1 = image1,
        image2 = image2,
        price = price,
        idCategory = idCategory,
        imagesToUpdate = null
    )
}
fun Product.toProductEntity(): ProductEntity{
    return ProductEntity(
        id= id?: "",
        name = name,
        description = description,
        image1 = image1 ?: "",
        image2 = image2 ?: "",
        price = price,
        idCategory = idCategory
    )
}