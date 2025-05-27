package com.svstudio.eccomerceapp.data.dataSource.remote.service

import com.svstudio.eccomerceapp.domain.model.CardTokenBody
import com.svstudio.eccomerceapp.domain.model.CardTokenResponse
import com.svstudio.eccomerceapp.domain.model.IdentificationType
import com.svstudio.eccomerceapp.domain.model.Installment
import com.svstudio.eccomerceapp.domain.model.PaymentBody
import com.svstudio.eccomerceapp.domain.model.PaymentResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MercadoPagoService {
    @GET("mercadopago/identidication_types")
    suspend fun  getIdentificationTypes(): Response<List<IdentificationType>>

    @GET("mercadopago/installments/{first_six_digits}/{amount}")
    suspend fun getInstallments(
        @Path("first_six_digits") firstSixDigits: Int,
        @Path("amount") amount: Double,
    ): Response<Installment>

    @POST("mercadopago/card_token")
    suspend fun crateCardToken(
        @Body cardTokenBody: CardTokenBody
    ): Response<CardTokenResponse>

    @POST("mercadopago/payments")
    suspend fun cratePayment(
        @Body paymentBody: PaymentBody
    ): Response<PaymentResponse>





}