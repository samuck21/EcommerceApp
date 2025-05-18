package com.svstudio.eccomerceapp.domain.usecase.categories

import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.domain.repository.CategoriesRepository
import java.io.File

class GetCategoryUseCase (private  val repository: CategoriesRepository) {
    suspend operator fun  invoke() = repository.getCatefories()
}