package com.svstudio.eccomerceapp.presentation.navigation.screen.client

import com.svstudio.eccomerceapp.domain.model.PaymentResponse

sealed class ShoppingBagScreen (val  route: String) {
    object  ShoppingBag: ShoppingBagScreen("client/shopping_bag")
    object  AddressList: ShoppingBagScreen("client/address/list")
    object  AddressCreate: ShoppingBagScreen("client/address/list")
    object  PaymentsForm: ShoppingBagScreen("client/payments/form")
    object  PaymentsInstallments: ShoppingBagScreen("client/payments/installments/{payment_form}"){
        fun passPaymentForm(paymentForm: String) = "client/payments/installments/$paymentForm"
    }
    object  PaymentsStatus: ShoppingBagScreen("client/payments/installments/{payment_response}"){
        fun passPaymentResponse(paymentResponse: String) = "client/payments/installments/$paymentResponse"
    }
}