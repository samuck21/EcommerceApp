package com.svstudio.eccomerceapp.presentation.scree_auth.admin.order.detail.componets
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.order.detail.AdminOrderDetailViewModel

@Composable
fun UpdateStatusOrder(vm: AdminOrderDetailViewModel = hiltViewModel()) {
    when(val response = vm.ordersStatusResponse) {
        Resource.Loading -> {
            //ProgressBar()
        }
        is Resource.Success -> {
            Toast.makeText(LocalContext.current, "La orden se ha actualizado correctamente", Toast.LENGTH_LONG).show()
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