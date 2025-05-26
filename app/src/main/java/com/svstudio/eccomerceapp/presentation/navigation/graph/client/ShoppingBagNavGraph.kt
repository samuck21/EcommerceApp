package com.svstudio.eccomerceapp.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ShoppingBagScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create.ClientAddressCreateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.list.ClientAddressListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.ClientPaymentsFormScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.shopping_bag.ClientShoppingBagScreen

fun NavGraphBuilder.ShoppingBagNavGraph(navController: NavHostController){
    navigation(
        route = Graph.SHOPPING_BAG,
        startDestination = ShoppingBagScreen.ShoppingBag.route
    ){


        composable( route = ShoppingBagScreen.ShoppingBag.route


        ) {

            ClientShoppingBagScreen(navController)
        }
        composable( route = ShoppingBagScreen.AddressList.route
        ) {
            ClientAddressListScreen(navController)
        }
        composable( route = ShoppingBagScreen.AddressCreate.route
        ) {
            ClientAddressCreateScreen(navController)
        }

        composable( route = ShoppingBagScreen.PaymentsForm.route
        ) {
            ClientPaymentsFormScreen(navController)
        }




    }
}