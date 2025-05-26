package com.svstudio.eccomerceapp.presentation.navigation.screen.client

sealed class ShoppingBagScreen (val  route: String) {
    object  ShoppingBag: ShoppingBagScreen("client/shopping_bag")
    object  AddressList: ShoppingBagScreen("client/address/list")
    object  AddressCreate: ShoppingBagScreen("client/address/list")


}