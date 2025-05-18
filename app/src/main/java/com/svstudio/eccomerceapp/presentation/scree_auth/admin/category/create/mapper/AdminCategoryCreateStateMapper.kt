package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.mapper

import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.AdminCategoryCreateState

fun  AdminCategoryCreateState.toCategory(): Category{
    return Category(
        name = name,
        description = description
    )
}