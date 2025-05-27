package com.svstudio.eccomerceapp.data.dataSource.remote

import com.svstudio.eccomerceapp.data.dataSource.remote.service.MercadoPagoService
import com.svstudio.eccomerceapp.domain.model.CardTokenBody
import com.svstudio.eccomerceapp.domain.model.CardTokenResponse
import com.svstudio.eccomerceapp.domain.model.IdentificationType
import com.svstudio.eccomerceapp.domain.model.Installment
import com.svstudio.eccomerceapp.domain.model.PaymentBody
import com.svstudio.eccomerceapp.domain.model.PaymentResponse
import retrofit2.Response

class MercadoPagoRemoteDataSourceImpl(private  val mercadoPagoService: MercadoPagoService):
    MercadoPagoRemoteDataSource {
    override suspend fun getIdentificationTypes(): Response<List<IdentificationType>> = mercadoPagoService.getIdentificationTypes()

    override suspend fun getInstallments(
        firstSixDigits: Int,
        amount: Double
    ): Response<Installment> = mercadoPagoService.getInstallments(firstSixDigits,amount)

    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Response<CardTokenResponse> = mercadoPagoService.crateCardToken(cardTokenBody)
    override suspend fun createPayment(paymentBody: PaymentBody): Response<PaymentResponse> = mercadoPagoService.cratePayment(paymentBody)
}