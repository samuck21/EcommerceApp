package com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create.components.ClientAddressCreateContent
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create.components.CreateAddress
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.list.components.ClientAddressListContent

@Composable
fun ClientAddressCreateScreen (navController: NavHostController, vm: ClientAddressCreateViewModel = hiltViewModel()){
  vm.getSessionData()
    Scaffold { paddindValues ->
        ClientAddressCreateContent(paddindValues)
    }
    CreateAddress()

}