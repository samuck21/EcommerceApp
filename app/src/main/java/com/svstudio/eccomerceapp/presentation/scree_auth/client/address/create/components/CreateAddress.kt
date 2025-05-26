package com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.AdminCategoryCreateViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.AdminCategoryListViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.components.AdminCategoryListContent
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.AdminProductListViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.components.AdminProductListContent
import com.svstudio.eccomerceapp.presentation.scree_auth.client.address.create.ClientAddressCreateViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list.ClientProductListViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list.components.ClientProductListContent

@Composable
fun CreateAddress(vm: ClientAddressCreateViewModel = hiltViewModel()) {

    when(val response = vm.addressResponse) {
        Resource.Loading -> {
            //  ProgressBar()
        }
        is Resource.Success -> {
            // 401 TOKEN
            vm.clearForm()
            Log.d("UpdateUser", "Data: ${response.data}")

            Toast.makeText(LocalContext.current, "Los datos se han actualizado correctamete", Toast.LENGTH_LONG).show()
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