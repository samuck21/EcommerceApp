package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.AdminCategoryListViewModel

@Composable
fun DeleteCategory(vm: AdminCategoryListViewModel = hiltViewModel()){

    when(val response = vm.deleteCategoriesResponse) {
        Resource.Loading -> {
            //  ProgressBar()
        }
        is Resource.Success -> {
            // 401 TOKEN
            Toast.makeText(LocalContext.current, "La categoria se ha eliminado correctamente", Toast.LENGTH_LONG).show()
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