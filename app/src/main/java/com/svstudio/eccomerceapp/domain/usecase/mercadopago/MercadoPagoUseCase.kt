package com.svstudio.eccomerceapp.domain.usecase.mercadopago

data class MercadoPagoUseCase(
    val getIdentificationType: GetIdentificationTypeUseCase,
    val getInstallments: GetInstallmentsUseCase
)
