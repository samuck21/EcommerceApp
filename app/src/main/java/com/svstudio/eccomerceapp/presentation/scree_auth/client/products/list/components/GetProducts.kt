package com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.AdminCategoryListViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.components.AdminCategoryListContent
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.AdminProductListViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.components.AdminProductListContent
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list.ClientProductListViewModel

@Composable
fun GetProducts(navController: NavHostController,paddingValues: PaddingValues,vm: ClientProductListViewModel = hiltViewModel()){

    when(val response = vm.productResponse) {
        Resource.Loading -> {
            //  ProgressBar()
        }
        is Resource.Success -> {
            // 401 TOKEN
            Log.d("GetCategories", "Data: ${response.data}")
           ClientProductListContent(navController, paddingValues, response.data)
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
            }
        }
    }
}