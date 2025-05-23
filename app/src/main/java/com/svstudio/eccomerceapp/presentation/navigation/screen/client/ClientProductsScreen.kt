package com.svstudio.eccomerceapp.presentation.navigation.screen.client

sealed class ClientProductsScreen (val  route: String) {
    object  ProductDetail: ClientProductsScreen("client/products/detail/{product}"){
        fun passProduct(product:String) = "client/products/detail/$product"
    }

}