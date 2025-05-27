package com.svstudio.eccomerceapp.presentation.scree_auth.client.order.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.client.order.list.componets.GetOrders

@Composable
fun ClientOrderListScreen(navController: NavHostController, vm: ClientOrderListViewModel = hiltViewModel()) {

    vm.getSessionData()

    Scaffold() { paddingValues ->
        GetOrders(navController = navController, paddingValues = paddingValues)
    }

}