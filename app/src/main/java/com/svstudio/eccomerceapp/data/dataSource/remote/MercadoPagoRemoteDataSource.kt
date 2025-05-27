package com.svstudio.eccomerceapp.data.dataSource.remote

import com.svstudio.eccomerceapp.domain.model.CardTokenBody
import com.svstudio.eccomerceapp.domain.model.CardTokenResponse
import com.svstudio.eccomerceapp.domain.model.IdentificationType
import com.svstudio.eccomerceapp.domain.model.Installment
import com.svstudio.eccomerceapp.domain.model.PaymentBody
import com.svstudio.eccomerceapp.domain.model.PaymentResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MercadoPagoRemoteDataSource {

    suspend fun getIdentificationTypes(): Response<List<IdentificationType>>
    suspend fun getInstallments(firstSixDigits: Int, amount: Double): Response<Installment>
    suspend fun createCardToken(cardTokenBody: CardTokenBody): Response<CardTokenResponse>
    suspend fun createPayment(paymentBody: PaymentBody): Response<PaymentResponse>
}