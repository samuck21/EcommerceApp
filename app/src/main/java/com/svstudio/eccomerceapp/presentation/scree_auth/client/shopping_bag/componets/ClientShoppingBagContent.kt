package com.svstudio.eccomerceapp.presentation.scree_auth.client.shopping_bag.componets

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ModalDrawer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.svstudio.eccomerceapp.domain.model.ShoppingBagProduct

@Composable
fun ClientShoppingBagContent(paddingValues: PaddingValues,shoppingBag: MutableList<ShoppingBagProduct>){

    LazyColumn (modifier = Modifier.padding(paddingValues)){
        items (items = shoppingBag) { shoppingBagProduct ->
            ClientShoppingBagItem(shoppingBagProduct)

        }

    }
}