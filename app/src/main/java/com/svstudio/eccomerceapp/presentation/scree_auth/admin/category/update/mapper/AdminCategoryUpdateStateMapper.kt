package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update.mapper

import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.AdminCategoryCreateState
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update.AdminCategoryUpdateState

fun  AdminCategoryUpdateState.toCategory(): Category{
    return Category(
        name = name,
        description = description
    )
}