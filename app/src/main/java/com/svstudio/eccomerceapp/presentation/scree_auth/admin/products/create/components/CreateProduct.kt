package com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create.components

import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.AdminCategoryCreateViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create.AdminProductCreateViewModel

@Composable
fun CreateProduct(vm: AdminProductCreateViewModel = hiltViewModel()) {

    when(val response = vm.productResponse) {
        Resource.Loading -> {

        }
        is Resource.Success -> {
            // 401 TOKEN
            vm.clearForm()
            Toast.makeText(LocalContext.current, "Los datos se han creado correctamete", Toast.LENGTH_LONG).show()
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_LONG).show()
            Log.d("Error Crear Product","Error${response}")
        }
        else -> {
            if (response != null) {
                Toast.makeText(LocalContext.current, "Hubo error desconocido", Toast.LENGTH_LONG).show()
                Log.d("Error Crear Product","Error${response}")
            }
        }
    }

}