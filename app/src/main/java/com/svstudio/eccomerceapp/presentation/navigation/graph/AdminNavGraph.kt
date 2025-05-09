package com.svstudio.eccomerceapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.AdminScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.AdminCategoryListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.AdminProductListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController){
    NavHost(
      navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    ){
        composable (route = AdminScreen.ProductList.route) {
            AdminProductListScreen()
        }
        composable (route = AdminScreen.CategoryList.route){
            AdminCategoryListScreen()
        }
        composable (route = AdminScreen.Profile.route) {
            ProfileScreen()
        }
    }
}