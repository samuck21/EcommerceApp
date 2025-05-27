package com.svstudio.eccomerceapp.domain.usecase.mercadopago

import com.svstudio.eccomerceapp.domain.model.CardTokenBody
import com.svstudio.eccomerceapp.domain.model.PaymentBody
import com.svstudio.eccomerceapp.domain.repository.MercadoPagoRepository

class CreatePaymentUseCase (private val repository: MercadoPagoRepository){
    suspend  operator fun invoke(paymentBody: PaymentBody)= repository.createPayment(paymentBody)
}