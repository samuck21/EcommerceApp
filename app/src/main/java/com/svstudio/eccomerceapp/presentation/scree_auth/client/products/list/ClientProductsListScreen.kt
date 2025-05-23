package com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list.components.ClientProductListContent
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list.components.GetProducts

@Composable
fun ClientProductListScreen(navController: NavHostController){
    Scaffold { paddingValues ->
        GetProducts(navController = navController, paddingValues = paddingValues)
    }

}