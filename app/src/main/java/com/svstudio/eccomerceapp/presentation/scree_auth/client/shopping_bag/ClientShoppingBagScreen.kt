package com.svstudio.eccomerceapp.presentation.scree_auth.client.shopping_bag

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ShoppingBagScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.shopping_bag.componets.ClientShoppingBagBottonBar
import com.svstudio.eccomerceapp.presentation.scree_auth.client.shopping_bag.componets.ClientShoppingBagContent

@Composable
fun ClientShoppingBagScreen(navController: NavHostController, vm: ClientShoppingBagViewModel = hiltViewModel()) {
    vm.getShoppingBag()
    Scaffold(
        topBar = {
            Icon( imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                modifier = Modifier.clickable{

                })
        },
        bottomBar = {
            ClientShoppingBagBottonBar(navController)
        }

    ) { paddingValues ->
        ClientShoppingBagContent(paddingValues, vm.shoppingBag)
    }
}

