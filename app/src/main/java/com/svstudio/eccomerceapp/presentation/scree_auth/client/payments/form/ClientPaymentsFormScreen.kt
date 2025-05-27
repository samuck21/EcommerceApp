package com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.componets.ClientPaymentsFormContent
import com.svstudio.eccomerceapp.presentation.scree_auth.client.payments.form.componets.GetIdentificationTypes

@Composable
fun ClientPaymentsFormScreen (navController: NavHostController, vm: ClientPaymentsFormViewModel = hiltViewModel()) {
   // vm.getInstallemts(vm.car)
    Scaffold () {paddingValues ->

        GetIdentificationTypes(paddingValues,navController)
    }
}