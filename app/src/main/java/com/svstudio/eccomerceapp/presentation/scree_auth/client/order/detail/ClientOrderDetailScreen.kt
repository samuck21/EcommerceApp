package com.svstudio.eccomerceapp.presentation.scree_auth.client.order.detail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.order.detail.componets.UpdateStatusOrder
import com.svstudio.eccomerceapp.presentation.scree_auth.client.order.detail.componets.ClientOrderDetailContent


@Composable
fun ClientOrderDetailScreen(navController: NavHostController, orderParam: String, vm: ClientOrderDetailViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {

        }
    ) { paddingValues ->
        ClientOrderDetailContent(paddingValues, vm.order)
    }
    UpdateStatusOrder()

}