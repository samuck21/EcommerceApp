package com.svstudio.eccomerceapp.presentation.scree_auth.admin.order.detail

import android.util.Log
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.order.detail.componets.AdminOrderDetailContent
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.order.detail.componets.UpdateStatusOrder

@Composable
fun AdminOrderDetailScreen(navController: NavHostController, orderParam: String, vm: AdminOrderDetailViewModel = hiltViewModel()) {

    Log.d("AdminOrderDetailScreen", "Order param: ${orderParam}")

    Scaffold(
        topBar = {

        }
    ) { paddingValues ->
        AdminOrderDetailContent(paddingValues, vm.order)
    }
    UpdateStatusOrder()

}