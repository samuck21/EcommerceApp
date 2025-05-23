package com.svstudio.eccomerceapp.presentation.scree_auth.client.products.detail

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil3.size.Scale
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.detail.componets.ClientProductDetailContent

@Composable
fun ClientProductDetailScreen(navController: NavHostController,productParam: String){
    Scaffold { paddingValues ->
        ClientProductDetailContent(paddingValues = paddingValues)

    }
}