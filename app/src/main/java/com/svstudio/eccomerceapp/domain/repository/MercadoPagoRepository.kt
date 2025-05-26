package com.svstudio.eccomerceapp.domain.repository

import com.svstudio.eccomerceapp.domain.model.IdentificationType
import com.svstudio.eccomerceapp.domain.model.Installment
import com.svstudio.eccomerceapp.domain.until.Resource
import kotlinx.coroutines.flow.Flow

interface MercadoPagoRepository {
    fun getIdentificationTypes():Flow<Resource<List<IdentificationType>>>
    fun getInstallments(firstSixDigits: Int,amount: Double):Flow <Resource<Installment>>
}