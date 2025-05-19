package com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list.components.ClientCategoryListContent
import com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list.components.GetCategories

@Composable
fun ClientCategoryListScreen(
 navController: NavHostController
){
    Scaffold { paddingValues ->
        GetCategories(paddingValues = paddingValues,navController = navController)
    }

}