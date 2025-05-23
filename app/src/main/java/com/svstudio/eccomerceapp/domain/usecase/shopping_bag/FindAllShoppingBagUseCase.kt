package com.svstudio.eccomerceapp.domain.usecase.shopping_bag

import com.svstudio.eccomerceapp.domain.repository.ShoppingBagRepository

class FindAllShoppingBagUseCase(private val repository: ShoppingBagRepository){
    operator  fun invoke() = repository.findAll()

}