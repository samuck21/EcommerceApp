package com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.components.AdminProductListContent

@Composable
fun AdminProductListScreen(){
    Scaffold {
        AdminProductListContent(it)
    }

}