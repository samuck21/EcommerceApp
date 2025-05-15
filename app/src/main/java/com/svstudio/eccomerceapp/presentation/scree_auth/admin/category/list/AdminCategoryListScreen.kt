package com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.svstudio.eccomerceapp.Greeting
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.components.AdminCategoryListContent

@Composable
fun AdminCategoryListScreen(navController: NavHostController){
    Scaffold (
         floatingActionButton = {
             FloatingActionButton(
                 containerColor = Color.DarkGray,
                 modifier = Modifier.padding(bottom = 60.dp),
                 onClick = {
                 navController.navigate(route = Graph.ADMIN_CATEGORY)
             }
             ) {
                 Icon(imageVector = Icons.Default.Add,
                     contentDescription = "",
                     tint = Color.White,
                 )
             }
         }
    ) {
        AdminCategoryListContent(it)
    }


}