package com.svstudio.eccomerceapp.domain.usecase.shopping_bag

import com.svstudio.eccomerceapp.domain.repository.ShoppingBagRepository

class FindByIdShoppingBagUseCase(private val repository: ShoppingBagRepository){
   suspend operator  fun invoke(id: String) = repository.findById(id)

}