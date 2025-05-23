package com.svstudio.eccomerceapp.presentation.navigation.graph.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.svstudio.eccomerceapp.presentation.navigation.Graph
import com.svstudio.eccomerceapp.presentation.navigation.screen.admin.AdminCategoryScreen
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ClientCategoryScreen
import com.svstudio.eccomerceapp.presentation.navigation.screen.roles.RolesScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.AdminCategoryCreateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update.AdminCategoryUpdateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.home.AdminHomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create.AdminProductCreateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.AdminProductListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.update.AdminProductUpdateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.home.ClientHomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.listByCategory.ClientProductByCategoryListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.roles.RolesScreen

fun NavGraphBuilder.ClientCategoryNavGraph(navController: NavHostController){
    navigation(
        route = Graph.CLIENT_CATEGORY,
        startDestination = ClientCategoryScreen.ProductList.route
    ){


        composable( route = ClientCategoryScreen.ProductList.route,
            arguments = listOf(navArgument ("category") {
                type = NavType.StringType
            })

        ) {
            it.arguments?.getString("category")?.let {
                ClientProductByCategoryListScreen(navController = navController,it)
            }

        }



    }
}