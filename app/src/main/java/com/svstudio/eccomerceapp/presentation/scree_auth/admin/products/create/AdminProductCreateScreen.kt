package com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create.components.AdminProductCreateContent

@Composable
fun AdminProductCreateScreen(navController: NavHostController,category: String){
    Log.d("AdminProductListScreen","Category:${category}")
    Scaffold {
        AdminProductCreateContent(it)
    }
}