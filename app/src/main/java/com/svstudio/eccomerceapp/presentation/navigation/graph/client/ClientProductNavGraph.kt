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
import com.svstudio.eccomerceapp.presentation.navigation.screen.client.ClientProductsScreen
import com.svstudio.eccomerceapp.presentation.navigation.screen.roles.RolesScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.create.AdminCategoryCreateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.category.update.AdminCategoryUpdateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.home.AdminHomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.create.AdminProductCreateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.list.AdminProductListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.admin.products.update.AdminProductUpdateScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.home.ClientHomeScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.detail.ClientProductDetailScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.client.products.listByCategory.ClientProductByCategoryListScreen
import com.svstudio.eccomerceapp.presentation.scree_auth.roles.RolesScreen

fun NavGraphBuilder.ClientProductNavGraph(navController: NavHostController){
    navigation(
        route = Graph.CLIENT_PRODUCT,
        startDestination = ClientProductsScreen.ProductDetail.route
    ){


        composable( route = ClientProductsScreen.ProductDetail.route,
            arguments = listOf(navArgument ("product") {
                type = NavType.StringType
            })

        ) {
            it.arguments?.getString("product")?.let {
                ClientProductDetailScreen(navController = navController,it)
            }

        }



    }
}