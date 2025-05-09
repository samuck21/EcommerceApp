package com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list.components.ClientProductListContent

@Composable
fun ClientProductListScreen(){
    Scaffold {
        ClientProductListContent(it)
    }

}