package com.svstudio.eccomerceapp.data.repository

import com.svstudio.eccomerceapp.data.dataSource.remote.MercadoPagoRemoteDataSource
import com.svstudio.eccomerceapp.domain.model.CardTokenBody
import com.svstudio.eccomerceapp.domain.model.CardTokenResponse
import com.svstudio.eccomerceapp.domain.model.IdentificationType
import com.svstudio.eccomerceapp.domain.model.Installment
import com.svstudio.eccomerceapp.domain.model.PaymentBody
import com.svstudio.eccomerceapp.domain.model.PaymentResponse
import com.svstudio.eccomerceapp.domain.repository.MercadoPagoRepository
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.domain.until.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MercadoPagoRepositoryImpl(private val remoteDataSource : MercadoPagoRemoteDataSource):
    MercadoPagoRepository {
    override fun getIdentificationTypes(): Flow<Resource<List<IdentificationType>>>  = flow {
        emit(ResponseToRequest.send(remoteDataSource.getIdentificationTypes()))
    }

    override fun getInstallments(
        firstSixDigits: Int,
        amount: Double
    ): Flow<Resource<Installment>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.getInstallments(firstSixDigits,amount)))
    }

    override suspend fun createCardToken(cardTokenBody: CardTokenBody): Resource<CardTokenResponse> =
        ResponseToRequest.send(
            remoteDataSource.createCardToken(cardTokenBody)
        )

    override suspend fun createPayment(paymentBody: PaymentBody): Resource<PaymentResponse> =
        ResponseToRequest.send(
            remoteDataSource.createPayment(paymentBody)
        )
}