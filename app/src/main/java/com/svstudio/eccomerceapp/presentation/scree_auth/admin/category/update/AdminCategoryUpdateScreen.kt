package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.componets.AdminCategoryCreateContent
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.componets.CreateCategory
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update.componets.AdminCategoryUpdateContent
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update.componets.UpdateCategory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminCategoryUpdateScreen(navController: NavHostController,categoryParam: String) {
    Log.d("AdminCategoryUpdateScreen","Data:$categoryParam")
    Scaffold (

    ) { it
        AdminCategoryUpdateContent()
    }
    UpdateCategory()
}