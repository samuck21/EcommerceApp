package com.svstudio.eccomerceapp.domain.usecase.mercadopago

import com.svstudio.eccomerceapp.domain.model.CardTokenBody
import com.svstudio.eccomerceapp.domain.repository.MercadoPagoRepository

class CreateCardTokenUseCase (private val repository: MercadoPagoRepository){
    suspend  operator fun invoke(cardTokenBody: CardTokenBody)= repository.createCardToken(cardTokenBody)
}