package com.svstudio.eccomerceapp.presentation.scree_auth.client.shopping_bag

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.client.shopping_bag.componets.ClientShoppingBagContent

@Composable
fun ClientShoppingBagScreen(navController: NavHostController) {
    Scaffold { paddingValues ->
        ClientShoppingBagContent(paddingValues)

    }
}