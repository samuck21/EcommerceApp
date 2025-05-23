package com.svstudio.eccomerceapp.domain.usecase.products

import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.domain.repository.ProductsRepository
import java.io.File

class FindAllUseCase (private val repository: ProductsRepository) {
    suspend operator fun invoke()= repository.findAll()
}