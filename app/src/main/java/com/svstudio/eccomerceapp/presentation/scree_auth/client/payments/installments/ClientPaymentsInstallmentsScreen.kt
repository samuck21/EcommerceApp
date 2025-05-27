package com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.installments

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.installments.componets.CreateCardToken
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.installments.componets.CreatePayment
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.installments.componets.GetInstallments

@Composable
fun ClientPaymentsInstallmentsScreen(navController: NavHostController, paymentFormParam: String, vm: ClientPaymentsInstallmentsViewModel = hiltViewModel()) {
    Log.d("ClientPaymentsInstallmentsScreen", "Param: ${vm.cardTokenBody}")
    vm.getInstallments(vm.cardTokenBody.cardNumber.substring(0, 6).toInt(), 100000.0)

    Scaffold(
        bottomBar = {
            Button(
                onClick = {
                  vm.createCardToken()
                }
            ) { Text("Confirmar Transaccion") }
        }
    ) {paddingValues ->
        GetInstallments(paddingValues = paddingValues)
    }
    CreateCardToken()
    CreatePayment(navController = navController)

}