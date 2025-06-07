package com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create.components.ClientAddressCreateContent
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create.components.CreateAddress
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.list.components.ClientAddressListContent

@Composable
fun ClientAddressCreateScreen (navController: NavHostController, vm: ClientAddressCreateViewModel = hiltViewModel()){
  vm.getSessionData()
    Scaffold (
        topBar = {
            Icon(
                imageVector = Icons.Default.KeyboardArrowLeft,
                contentDescription = "",
                modifier = Modifier
                    .size(90.dp)
                    .padding(20.dp)
                    .clickable{
                    navController.popBackStack()
                },
                tint = Color.White
            )
        }
    ){ paddindValues ->
        ClientAddressCreateContent(paddindValues)
    }
    CreateAddress()

}