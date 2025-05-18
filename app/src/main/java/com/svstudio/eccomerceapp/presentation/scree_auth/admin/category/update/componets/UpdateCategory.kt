package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update.componets

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.until.Resource
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.AdminCategoryCreateViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update.AdminCategoryUpdateViewModel

@Composable
fun UpdateCategory(vm: AdminCategoryUpdateViewModel = hiltViewModel()) {

    when(val response = vm.categoryResponse) {
        Resource.Loading -> {
          //  ProgressBar()
        }
        is Resource.Success -> {
            // 401 TOKEN
           // vm.clearForm()
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