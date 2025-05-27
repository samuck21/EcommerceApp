package com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.status

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.status.componets.ClientPaymentsStatusContent


@Composable
fun ClientPaymentsStatusScreen(navController: NavHostController, paymentResponseParam: String) {

    Scaffold() { paddingValues ->
        ClientPaymentsStatusContent(paddingValues = paddingValues, navController = navController)
    }

}