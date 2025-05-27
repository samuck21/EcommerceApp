package com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.componets

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
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.components.AdminCategoryListContent
import com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list.ClientCategoryListViewModel
import com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list.components.ClientCategoryListContent
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.ClientPaymentsFormViewModel

@Composable
fun GetIdentificationTypes(paddingValues: PaddingValues,navController: NavHostController,vm: ClientPaymentsFormViewModel= hiltViewModel()){

    when(val response = vm.identificationTypesResponse) {
        Resource.Loading -> {
            //  ProgressBar()
        }
        is Resource.Success -> {
            // 401 TOKEN
            Log.d("GetCategories", "Data: ${response.data}")
            ClientPaymentsFormContent(paddingValues = paddingValues, identificationTypes = response.data.map { identificationType -> identificationType.id }, navController = navController)
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