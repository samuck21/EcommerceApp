package com.svstudio.eccomerceapp.domain.usecase.orders

import com.svstudio.eccomerceapp.domain.repository.OrdersRepository

class FindAllOrdersUseCase(private val repository: OrdersRepository) {

    operator fun invoke() = repository.findAll()

}