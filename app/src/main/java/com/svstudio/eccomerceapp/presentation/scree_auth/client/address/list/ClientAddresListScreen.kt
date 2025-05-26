package com.svstudio.eccomerceapp.presentation.scree_auth.client.address.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ShoppingBagScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.list.components.ClientAddressListContent
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.list.components.GetAddress

@Composable
fun ClientAddressListScreen (navController: NavHostController, vm: ClientAddressListViewModel = hiltViewModel()){
    vm.getSessionData()
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color.DarkGray,
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = {
                    navController.navigate(route = ShoppingBagScreen.AddressCreate.route)
                }
            ) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White,
                )
            }
        },
        bottomBar = {
            Button(
                modifier = Modifier.size(height = 40.dp, width = 100.dp),
               onClick = {
                   navController.navigate(route = ShoppingBagScreen.PaymentsForm.route)
               }
            ) {
                Text("Continuar")
            }
        }

    ){ paddindValues ->

        GetAddress(paddindValues)

    }

}