package com.svstudio.eccomerceapp.domain.usecase.mercadopago

import com.svstudio.eccomerceapp.domain.repository.MercadoPagoRepository

class GetInstallmentsUseCase (private val repository: MercadoPagoRepository){
    operator  fun invoke(firstSixDigits: Int, amount: Double)= repository.getInstallments(firstSixDigits,amount)
}