package com.svstudio.eccomerceapp.presentation.scree_auth.roles

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.roles.componets.RolesContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun RolesScreen(navController: NavHostController){
    Scaffold (

    ) { paddingValues ->
        RolesContent(paddingValues, navController)

    }
}
