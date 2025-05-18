package com.svstudio.eccomerceapp.domain.usecase.categories

import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.domain.repository.CategoriesRepository
import java.io.File

class CreateCategoryUseCase (private  val repository: CategoriesRepository) {
    suspend operator fun  invoke(category: Category,file: File) = repository.create(category,file)
}