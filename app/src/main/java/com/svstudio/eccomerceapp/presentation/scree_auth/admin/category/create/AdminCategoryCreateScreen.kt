package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.componets.AdminCategoryCreateContent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminCategoryCreateScreen(navController: NavHostController) {
    Scaffold (

    ) { it
        AdminCategoryCreateContent()
    }
}