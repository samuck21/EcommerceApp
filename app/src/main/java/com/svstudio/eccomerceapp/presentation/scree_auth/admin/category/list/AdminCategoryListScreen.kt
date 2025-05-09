package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.components.AdminCategoryListContent

@Composable
fun AdminCategoryListScreen(){
    Scaffold {
        AdminCategoryListContent(it)
    }

}