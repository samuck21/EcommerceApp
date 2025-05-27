package com.svstudio.eccomerceapp.domain.usecase.orders

import com.svstudio.eccomerceapp.domain.repository.OrdersRepository

class UpdateStatusOrdersUseCase(private val repository: OrdersRepository) {

    suspend operator fun invoke(id: String) = repository.updateStatus(id)

}