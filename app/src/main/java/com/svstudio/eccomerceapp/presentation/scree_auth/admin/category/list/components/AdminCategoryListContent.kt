package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.model.Category

@Composable
fun AdminCategoryListContent( navController: NavHostController,categories: List<Category>,paddingValues: PaddingValues){
    LazyColumn(
        modifier = Modifier.fillMaxWidth().padding(paddingValues)
    ) {
        items(
            items = categories,
            )
        { category ->
            AdminCategoryListItem(navController,category)
        }
    }
}