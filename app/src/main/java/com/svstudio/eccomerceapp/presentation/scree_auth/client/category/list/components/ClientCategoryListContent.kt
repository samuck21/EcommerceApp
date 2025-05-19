package com.svstudio.eccomerceapp.presentation.scree_auth.client.category.list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.model.Category

@Composable
fun ClientCategoryListContent(
    paddingValues: PaddingValues,
    navController: NavHostController,
    categories: List<Category>
    ){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
       items(categories) { category ->
          ClientCategoryListItem(
              navController =  navController,
              category = category
          )
       }
    }
}