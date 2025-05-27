package com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.installments.componets
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.installments.ClientPaymentsInstallmentsViewModel

@Composable
fun GetInstallments(paddingValues: PaddingValues, vm: ClientPaymentsInstallmentsViewModel = hiltViewModel()) {
    when(val response = vm.installmentsResponse) {
        Resource.Loading -> {
           //ProgressBar()
        }
        is Resource.Success -> {
            ClientPaymentsInstallmentsContent(paddingValues,  installments = response.data.payerCosts)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}