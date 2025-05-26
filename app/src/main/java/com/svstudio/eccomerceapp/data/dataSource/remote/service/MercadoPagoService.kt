package com.svstudio.eccomerceapp.data.dataSource.remote.service

import com.svstudio.eccomerceapp.domain.model.IdentificationType
import com.svstudio.eccomerceapp.domain.model.Installment
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MercadoPagoService {
    @GET("mercadopago/identidication_types")
    suspend fun  getIdentificationTypes(): Response<List<IdentificationType>>

    @GET("mercadopago/installments/{first_six_digits}/{amount}")
    suspend fun getInstallments(
        @Path("first_six_digits") firstSixDigits: Int,
        @Path("amount") amount: Double,
    ): Response<Installment>
}