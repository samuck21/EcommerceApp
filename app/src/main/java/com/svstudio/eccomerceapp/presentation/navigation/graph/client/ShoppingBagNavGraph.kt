package com.svstudio.eccomerceapp.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ClientCategoryScreen
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ShoppingBagScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create.ClientAddressCreateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.list.ClientAddressListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.ClientPaymentsFormScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.installments.ClientPaymentsInstallmentsScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.status.ClientPaymentsStatusScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.detail.ClientProductDetailScreen
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

        composable( route = ShoppingBagScreen.PaymentsInstallments.route,
            arguments = listOf(navArgument ("payment_form") {
                type = NavType.StringType
            })

        ) {
            it.arguments?.getString("payment_form")?.let {
                ClientPaymentsInstallmentsScreen(navController = navController, it)
            }
        }

        composable( route = ShoppingBagScreen.PaymentsStatus.route,
            arguments = listOf(navArgument ("payment_response") {
                type = NavType.StringType
            })

        ) {
            it.arguments?.getString("payment_response")?.let {
                ClientPaymentsStatusScreen(navController = navController, it)
            }
        }

    }






}