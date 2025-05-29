package com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.model.Product
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.AdminProductListViewModel

@Composable
fun AdminProductListContent(navController:NavHostController, paddingValues: PaddingValues, products: List<Product>){
    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = com.svstudio.eccomerceapp.R.drawable.profile_background),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }

    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()

    ) {
        items(items= products)
        { product ->
            AdminProductListItem(navController,product)
        }

    }

}