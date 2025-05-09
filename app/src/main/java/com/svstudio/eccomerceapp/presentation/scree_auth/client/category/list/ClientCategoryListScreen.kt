package com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

import com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list.components.ClientCategoryListContent

@Composable
fun ClientCategoryListScreen(){
    Scaffold {
        ClientCategoryListContent(it)
    }

}