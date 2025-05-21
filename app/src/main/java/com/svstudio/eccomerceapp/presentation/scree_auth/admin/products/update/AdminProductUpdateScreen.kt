package com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.update

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create.components.AdminProductCreateContent
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create.components.CreateProduct
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.update.components.AdminProductUpdateContent
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.update.components.UpdateProduct

@Composable
fun AdminProductUpdateScreen(navController: NavHostController,productParam: String){
    Log.d("AdminProductListScreen","Category:${productParam}")
    Scaffold {
        AdminProductUpdateContent(it)
    }
    UpdateProduct()
}