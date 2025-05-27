package com.svstudio.eccomerceapp.domain.repository

import com.svstudio.eccomerceapp.domain.model.CardTokenBody
import com.svstudio.eccomerceapp.domain.model.CardTokenResponse
import com.svstudio.eccomerceapp.domain.model.IdentificationType
import com.svstudio.eccomerceapp.domain.model.Installment
import com.svstudio.eccomerceapp.domain.model.PaymentBody
import com.svstudio.eccomerceapp.domain.model.PaymentResponse
import com.svstudio.eccomerceapp.domain.until.Resource
import kotlinx.coroutines.flow.Flow

interface MercadoPagoRepository {
    fun getIdentificationTypes():Flow<Resource<List<IdentificationType>>>
    fun getInstallments(firstSixDigits: Int,amount: Double):Flow <Resource<Installment>>
    suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse>
    suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse>

}