package com.svstudio.eccomerceapp.presentation.scree_auth.client.products.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.components.AdminProductListItem
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.components.DeleteProduct

@Composable
fun ClientProductListContent(navController:NavHostController, paddingValues: PaddingValues, products: List<Product>){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(paddingValues)
    ) {
        items (items= products)
        { product ->
            ClientProductListItem(navController,product)
        }

    }
}