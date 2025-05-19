package com.svstudio.eccomerceapp.data.mapper

import com.svstudio.eccomerceapp.data.dataSource.local.entity.CategoryEntity
import com.svstudio.eccomerceapp.domain.model.Category

fun CategoryEntity.toCategory(): Category {
    return Category(
        id=id,
        name =name,
        description =description,
        image= image,
    )
}
fun Category.toCategoryEntity(): CategoryEntity{
    return CategoryEntity(
        id= id?: "",
        name = name,
        description = description,
        image = image ?: ""
    )
}