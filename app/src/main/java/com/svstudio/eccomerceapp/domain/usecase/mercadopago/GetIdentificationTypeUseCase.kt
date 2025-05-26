package com.svstudio.eccomerceapp.domain.usecase.mercadopago

import com.svstudio.eccomerceapp.domain.repository.MercadoPagoRepository

class GetIdentificationTypeUseCase (private val repository: MercadoPagoRepository){
    operator  fun invoke() = repository.getIdentificationTypes()
}