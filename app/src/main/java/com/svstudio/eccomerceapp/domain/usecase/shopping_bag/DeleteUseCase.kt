package com.svstudio.eccomerceapp.domain.usecase.shopping_bag

import com.svstudio.eccomerceapp.domain.model.ShoppingBagProduct
import com.svstudio.eccomerceapp.domain.repository.ShoppingBagRepository

class DeleteUseCase(private val repository: ShoppingBagRepository){
  suspend  operator  fun invoke(id: String) {
      repository.delete(id)
  }

}