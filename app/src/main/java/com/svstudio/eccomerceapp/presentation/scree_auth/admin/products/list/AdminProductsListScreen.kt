package com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.domain.model.Category
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.admin.AdminCategoryScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.components.AdminProductListContent
import kotlin.math.log

@Composable
fun AdminProductListScreen(navController: NavHostController,category: String){
    Log.d("AdminProductListScreen","Category:${category}")
    val categoryParse = Category.fromJson(category).toJson()
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                containerColor = Color.DarkGray,
                modifier = Modifier.padding(bottom = 60.dp),
                onClick = {
                    navController.navigate(route = AdminCategoryScreen.ProductCreate.passCategory(categoryParse))
                }
            ) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White,
                )
            }
        }
    ) {
        AdminProductListContent(it)
    }

}