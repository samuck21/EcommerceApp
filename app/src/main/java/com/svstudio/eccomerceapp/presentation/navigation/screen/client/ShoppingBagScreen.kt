package com.svstudio.eccomerceapp.presentation.navigation.screen.client

sealed class ShoppingBagScreen (val  route: String) {
    object  ShoppingBag: ShoppingBagScreen("client/shopping_bag")


}