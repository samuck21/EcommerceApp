package com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.AdminProductListViewModel

@Composable
fun DeleteProduct(vm: AdminProductListViewModel = hiltViewModel()){

    when(val response = vm.productsDeleteResponse) {
        Resource.Loading -> {
            //  ProgressBar()
        }
        is Resource.Success -> {
            // 401 TOKEN
            Log.d("GetCategories", "Data: ${response.data}")
            Toast.makeText(LocalContext.current, "el producto se elemino correctamente ", Toast.LENGTH_LONG).show()

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