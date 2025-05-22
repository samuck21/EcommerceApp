package com.svstudio.eccomerceapp.domain.usecase.products

import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.domain.repository.ProductsRepository
import java.io.File

class UpdateProductWithImageUseCase (private val repository: ProductsRepository) {
    suspend operator fun invoke(id: String,product: Product,files: List<File>)= repository.updateWithImage(id,product,files)
}