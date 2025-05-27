package com.svstudio.eccomerceapp.domain.usecase.orders

import com.svstudio.eccomerceapp.domain.repository.OrdersRepository

class FindByClientOrdersUseCase(private val repository: OrdersRepository) {

    operator fun invoke(idClient: String) = repository.findByClient(idClient)

}