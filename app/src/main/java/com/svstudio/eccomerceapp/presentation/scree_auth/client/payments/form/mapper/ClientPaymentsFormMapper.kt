package com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.mapper

import com.svstudio.eccomerceapp.domain.model.CardTokenBody
import com.svstudio.eccomerceapp.domain.model.Cardholder
import com.svstudio.eccomerceapp.domain.model.Identification
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.ClientPaymentsFormState

fun ClientPaymentsFormState.toCardTokenBody(): CardTokenBody {
    return CardTokenBody(
        cardNumber = cardNumber,
        expirationMonth = expirationMonth.toInt(),
        expirationYear = expirationYear,
        securityCode = securityCode,
        cardholder = Cardholder(
            name = name,
            identification = Identification(
                type = type,
                number = number
            )
        )
    )
}