package com.svstudio.eccomerceapp.presentation.navigation.graph.admin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.graph.profile.ProfileNavGraph
import com.svstudio.eccomerceapp.presentation.navigation.screen.admin.AdminScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.list.AdminCategoryListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.AdminProductListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.profile.info.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController){
    NavHost(
      navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.CategoryList.route
    ){
//        composable (route = AdminScreen.ProductList.route) {
//            AdminProductListScreen()
//        }
        composable (route = AdminScreen.CategoryList.route){
            AdminCategoryListScreen(navController)
        }
        composable (route = AdminScreen.Profile.route) {
            ProfileScreen(navController)
        }
        ProfileNavGraph(navController)
        AdminCategoryNavGraph(navController)
    }
}